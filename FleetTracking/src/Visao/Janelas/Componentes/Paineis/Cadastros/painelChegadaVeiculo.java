/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis.Cadastros;

import Persistencia.DAO;
import Persistencia.Database.CadFuncionario;
import Persistencia.Database.CadVeiculo;
import Persistencia.Database.CadViagem;
import Visao.Janelas.Componentes.Campos.JLabelEditInteger;
import Visao.Janelas.Componentes.Campos.JLabelEditStringComConsulta;
import Visao.Janelas.Componentes.Campos.JLabelEditTextArea;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MATHEUS-NOTE
 */
public class painelChegadaVeiculo extends JPanelCadastro {
    
    JLabelEditStringComConsulta motorista;
    JLabelEditStringComConsulta veiculo;
    private JLabelEditInteger quilometragem;
    private JLabelEditTextArea conservacao;
    
    private CadViagem obj;
    private DAO dao;
    private String pesquisa = "id";

    public painelChegadaVeiculo() throws ParseException  {
        
        motorista = new JLabelEditStringComConsulta("Motorista Responsável:", 5, 35, 600, "CadFuncionario where AUSENTE=false", "registro", true);
        veiculo = new JLabelEditStringComConsulta("Veículo:", 5, 75, 500, "CadVeiculo where AUSENTE=false", "placa", true);
        quilometragem = new JLabelEditInteger("*Km:", 515, 75, 75, false, "", true);
        conservacao = new JLabelEditTextArea("Estado de Concervação:", 5, 115, 610, false);
        
        this.add(motorista);
        this.add(veiculo);
        this.add(quilometragem);
        this.add(conservacao);
        
        setSize(500, 340);
        super.setClassEntity("CadViagem where STATUS=false");
        super.setPesquisa(pesquisa);
        
    }

    @Override
    public void setInstanceObj() {
        CadViagem cc = obj;
        CadVeiculo v = (CadVeiculo) veiculo.getReferancia();
        CadFuncionario f = (CadFuncionario) motorista.getReferancia();
        
        if (this.getUpdate()){
            cc.setId(Long.parseLong(super.getId()));
        }
        cc.setFinalizada(true);
        if (getQuilometragem(v)) {
            cc.setDataChegada(getDataSistema());
            cc.setMotorista(f);
            cc.setVeiculo(v);
            cc.setRelatorioDanos(conservacao.getText());
            cc.setKmChegada(Double.parseDouble(quilometragem.getText()));

            v.setQuilometragem(Double.parseDouble(quilometragem.getText()));
            v.setConservacao(v.getConservacao()+"\n"+conservacao.getText());
            v.setAusente(false);
            
            f.setAusente(false);


            super.setObjEntity(v);
            super.setObjEntity(f);
            super.setObjEntity(cc);
        }
    }

    @Override
    public void getInstanceObj(Object objSelect) {
    
        obj = (CadViagem) objSelect;
        super.setId(obj.getId()+"");
        
        this.setMotorista(obj.getMotorista());
        this.setVeiculo(obj.getVeiculo());
        this.setQuilometragem(obj.getKmChegada());
        this.setConservacao(obj.getRelatorioDanos());
        
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem.setText(""+ quilometragem);
    }

    public void setConservacao(String conservacao) {
        this.conservacao.setText(conservacao);
    }

    public void setMotorista(CadFuncionario motorista) {
        this.motorista.setReferancia(motorista);
    }

    public void setVeiculo(CadVeiculo veiculo) {
        this.veiculo.setReferancia(veiculo);
    }
    
    public boolean getQuilometragem(CadVeiculo v) {
        double d = Double.parseDouble(quilometragem.getText());
        
        if (d <= v.getQuilometragem()) {
            JOptionPane.showMessageDialog(this, "A quilometragem é invalida \n"
                    + "Por favor corrija!");
            return false;
        } else {
            return true;
        }        
    }

    public Date getDataSistema() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date(System.currentTimeMillis());
        String data = dateFormat.format(d);
        try {
            d = dateFormat.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(painelSaidaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return d;
    }
    
    @Override
    public void setEditavel(boolean b) {
    
        motorista.setEnabled(!b);
        veiculo.setEnabled(!b);
        
    }

    @Override
    public void limpar() {}

    @Override
    public boolean objValido(Object obj) {
        CadViagem v = (CadViagem) obj;
        
        return v.validar();
    }
    
}

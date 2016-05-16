/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis.Cadastros;

import Persistencia.Database.CadFuncionario;
import Persistencia.Database.CadVeiculo;
import Persistencia.Database.CadViagem;
import Visao.Janelas.Componentes.Campos.JLabelEditStringComConsulta;
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
 * @author jfilhogn
 */
public class painelSaidaVeiculo extends JPanelCadastro {
    
    JLabelEditStringComConsulta motorista;
    JLabelEditStringComConsulta veiculo;
    
    private CadViagem dao;
    private String pesquisa = "id";
    
     public painelSaidaVeiculo() throws ParseException  {
        
        motorista = new JLabelEditStringComConsulta("*Motorista Responsável:", 5, 35, 600, "CadFuncionario", "registro", true);
        veiculo = new JLabelEditStringComConsulta("*Veículo:", 5, 75, 600, "CadVeiculo", "placa", true);
        
        this.add(motorista);
        this.add(veiculo);
        
        setSize(500, 200);
        super.setClassEntity("CadViagem");
        super.setPesquisa(pesquisa);
    }  
    
    @Override
    public void setInstanceObj() {
    
        CadViagem cc = new CadViagem();
        CadVeiculo v = (CadVeiculo) veiculo.getReferancia();
        CadFuncionario f = (CadFuncionario) motorista.getReferancia();
                
        if (this.getUpdate()){
            cc.setId(Long.parseLong(super.getId()));
        }
        cc.setDataSaida(getDataSistema());
        cc.setMotorista(f);
        cc.setVeiculo(v);
        try {
            cc.setKmSaida(v.getQuilometragem());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo veículo não foi preenchido!");
        }
        cc.setFinalizada(false);
        
        super.setObjEntity(cc);
    }

    @Override
    public void getInstanceObj(Object objSelect) {
    
        dao = (CadViagem) objSelect;
        super.setId(dao.getId()+"");
        
        this.setMotorista(dao.getMotorista());
        this.setVeiculo(dao.getVeiculo());
    
    }

    public void setMotorista(CadFuncionario motorista) {
        this.motorista.setReferancia(motorista);
    }

    public void setVeiculo(CadVeiculo veiculo) {
        this.veiculo.setReferancia(veiculo);
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
    public void setEditavel(boolean b) {}

    @Override
    public void limpar() {}

    @Override
    public boolean objValido(Object obj) {
        CadViagem v = (CadViagem) obj;
        
        return v.validar();
    }
}

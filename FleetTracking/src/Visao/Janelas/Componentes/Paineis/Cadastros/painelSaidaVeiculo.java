/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis.Cadastros;
import Visao.Janelas.Componentes.Campos.JLabelEditPlaca;
import Visao.Janelas.Componentes.Campos.JLabelEditRenavam;
import Visao.Janelas.Componentes.Campos.JLabelEditString;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import Visao.Janelas.Componentes.Campos.JLabelEditCpf;
import java.text.ParseException;
/**
 *
 * @author jfilhogn
 */
public class painelSaidaVeiculo extends JPanelCadastro {
    
    private JLabelEditString marca;
    private JLabelEditString modelo;
    private JLabelEditPlaca numeroPlaca;
    private JLabelEditCpf cpfMotorista;
    private JLabelEditString nomeMotorista;
    
    //TODO fiz no modo que pensei, temos que ver se o formato é dessa forma
    private String dataSaida;
    private String observacoes;
    private String combustivelPresente;
    //private JRadioButtonEdit categoriaCNH; criar a classe JRadioButtonEdit
    //private JTextAreaEdit comentarios; criar a classe JTextAreaEdit

    //private CadVeiculo dao;
    private String pesquisa = "motorista";
    
     public painelSaidaVeiculo() throws ParseException  {
        
        marca = new JLabelEditString("Marca:", 5, 35, 400);
        modelo = new JLabelEditString("Modelo:", 5, 75, 200);
        numeroPlaca = new JLabelEditPlaca("Número da Placa:", 430, 75, 200);
        cpfMotorista = new JLabelEditCpf("Número do CPF do motorista", 430,75, 200);
        nomeMotorista = new JLabelEditString("Nome do motorista", 430,75, 200);
        //TODO Falta realizar os privateString
        
        this.add(marca);
        this.add(modelo);
        this.add(numeroPlaca);
        this.add(cpfMotorista);
        this.add(nomeMotorista);
        
        setSize(500, 200);
        super.setClassEntity("CadVeiculo");
        super.setPesquisa(pesquisa);
    }  
    
    @Override
    public void setInstanceObj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getInstanceObj(Object objSelect) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEditavel(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setMarca(String text) {
        this.marca.setText(text);
    }

    public void setModelo(String text) {
        this.modelo.setText(text);
    }

    public void setNumeroPlaca(String text) {
        this.numeroPlaca.setText(text);
    }
    
    public void setCpfMotorista(String text){
        this.cpfMotorista.setText(text);
    }
    
    public void setNomeMotorista(String text){
        this.nomeMotorista.setText(text);
    }
    
    //TODO falta terminar os outros SET
    
}

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
import java.text.ParseException;


/**
 *
 * @author jfilhogn
 */
public class painelVeiculo extends JPanelCadastro {
    
    private JLabelEditString marca;
    private JLabelEditString modelo;
    private JLabelEditRenavam numeroRenavam;
    private JLabelEditPlaca numeroPlaca;
    //private JRadioButtonEdit categoriaCNH; criar a classe JRadioButtonEdit
    //private JTextAreaEdit comentarios; criar a classe JTextAreaEdit

    //private CadVeiculo dao;
    private String pesquisa = "renavam";

     public painelVeiculo() throws ParseException  {
        
        marca = new JLabelEditString("Marca:", 5, 35, 400);
        modelo = new JLabelEditString("Modelo:", 5, 75, 200);
        numeroRenavam = new JLabelEditRenavam("Numero do Renavam:", 215, 75, 200);
        numeroPlaca = new JLabelEditPlaca("Número da Placa:", 430, 75, 200);
        
        this.add(marca);
        this.add(modelo);
        this.add(numeroRenavam);
        this.add(numeroPlaca);
        
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

    public void setRenavam(String text) {
        this.numeroRenavam.setText(text);
    }

    public void setNumeroPlaca(String text) {
        this.numeroPlaca.setText(text);
    }
    
    
}

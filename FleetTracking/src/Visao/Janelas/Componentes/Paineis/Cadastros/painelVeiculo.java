/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis.Cadastros;
import Persistencia.Database.CadVeiculo;
import Visao.Janelas.Componentes.Campos.JLabelEditInteger;
import Visao.Janelas.Componentes.Campos.JLabelEditPlaca;
import Visao.Janelas.Componentes.Campos.JLabelEditRenavam;
import Visao.Janelas.Componentes.Campos.JLabelEditString;
import Visao.Janelas.Componentes.Campos.JLabelEditTextArea;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import java.text.ParseException;


/**
 *
 * @author jfilhogn
 */
public class painelVeiculo extends JPanelCadastro {
    
    private JLabelEditString marca;
    private JLabelEditString modelo;
    private JLabelEditInteger ano;
    private JLabelEditInteger quilometragem;
    private JLabelEditRenavam numeroRenavam;
    private JLabelEditPlaca numeroPlaca;
    private JLabelEditString categoriaCNH;
    private JLabelEditTextArea conservacao;
    private JLabelEditTextArea comentarios;

    private CadVeiculo dao;
    private String pesquisa = "renavam";

     public painelVeiculo() throws ParseException  {
        
        marca = new JLabelEditString("Marca:", 5, 35, 300);
        modelo = new JLabelEditString("Modelo:", 315, 35, 300);
        numeroRenavam = new JLabelEditRenavam("Numero do Renavam:", 5, 75, 140);
        numeroPlaca = new JLabelEditPlaca("Número da Placa:", 155, 75, 140);
        categoriaCNH = new JLabelEditString("CNH:", 305, 75, 140);
        ano = new JLabelEditInteger("Ano:", 455, 75, 75, true, "####");
        quilometragem = new JLabelEditInteger("Km:", 540, 75, 75, false, "");
        comentarios = new JLabelEditTextArea("Comentários adicionais:", 5, 115, 610, false);
        conservacao = new JLabelEditTextArea("Estado de Concervação:", 5, 255, 610, false);
        
        this.add(marca);
        this.add(modelo);
        this.add(numeroRenavam);
        this.add(numeroPlaca);
        this.add(categoriaCNH);
        this.add(ano);
        this.add(quilometragem);
        this.add(comentarios);
        this.add(conservacao);
        
        setSize(500, 480);
        super.setClassEntity("CadVeiculo");
        super.setPesquisa(pesquisa);
    }  
    
    @Override
    public void setInstanceObj() {}

    @Override
    public void getInstanceObj(Object objSelect) {}

    @Override
    public void setEditavel(boolean b) {}

    @Override
    public void limpar() {}
    
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

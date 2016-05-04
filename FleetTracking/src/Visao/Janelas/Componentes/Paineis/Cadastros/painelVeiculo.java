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
    private JLabelEditRenavam renavam;
    private JLabelEditPlaca placa;
    private JLabelEditString categoriaCNH;
    private JLabelEditTextArea conservacao;
    private JLabelEditTextArea comentarios;

    private CadVeiculo dao;
    private String pesquisa = "renavam";

     public painelVeiculo() throws ParseException  {
        
        marca = new JLabelEditString("Marca:", 5, 35, 300, true);
        modelo = new JLabelEditString("Modelo:", 315, 35, 300, true);
        renavam = new JLabelEditRenavam("Numero do Renavam:", 5, 75, 140, true);
        placa = new JLabelEditPlaca("Número da Placa:", 155, 75, 140, true);
        categoriaCNH = new JLabelEditString("CNH:", 305, 75, 140, true);
        ano = new JLabelEditInteger("Ano:", 455, 75, 75, true, "####", true);
        quilometragem = new JLabelEditInteger("Km:", 540, 75, 75, false, "", true);
        comentarios = new JLabelEditTextArea("Comentários adicionais:", 5, 115, 610, false);
        conservacao = new JLabelEditTextArea("Estado de Concervação:", 5, 255, 610, false);
        
        this.add(marca);
        this.add(modelo);
        this.add(renavam);
        this.add(placa);
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
    public void setInstanceObj() {
    
        CadVeiculo cc = new CadVeiculo();
        
        if (this.getUpdate()){
            cc.setId(Long.parseLong(super.getId()));
        }
        cc.setAno(Integer.parseInt(ano.getText()));
        cc.setMarca(marca.getText());
        cc.setModelo(modelo.getText());
        cc.setRenavam(renavam.getText());
        cc.setPlaca(placa.getText());
        cc.setCategoriaCNH(categoriaCNH.getText());
        cc.setComentarios(comentarios.getText());
        cc.setConservacao(conservacao.getText());
        cc.setQuilometragem(Double.parseDouble(quilometragem.getText()));
        
        super.setObjEntity(cc);
        
    }

    @Override
    public void getInstanceObj(Object objSelect) {
    
        dao = (CadVeiculo) objSelect;
        super.setId(dao.getId()+"");
        
        this.setMarca(dao.getMarca());
        this.setModelo(dao.getModelo());
        this.setAno(dao.getAno());
        this.setQuilometragem(dao.getQuilometragem());
        this.setRenavam(dao.getRenavam());
        this.setPlaca(dao.getPlaca());
        this.setCategoriaCNH(dao.getCategoriaCNH());
        this.setConservacao(dao.getConservacao());
        this.setComentarios(dao.getComentarios());
                
    }

    public void setMarca(String marca) {
        this.marca.setText(marca);
    }

    public void setModelo(String modelo) {
        this.modelo.setText(modelo);
    }

    public void setAno(int ano) {
        this.ano.setText(""+ano);
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem.setText(""+quilometragem);
    }

    public void setRenavam(String renavam) {
        this.renavam.setText(renavam);
    }

    public void setPlaca(String placa) {
        this.placa.setText(placa);
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH.setText(categoriaCNH);
    }

    public void setConservacao(String conservacao) {
        this.conservacao.setText(conservacao);
    }

    public void setComentarios(String comentarios) {
        this.comentarios.setText(comentarios);
    }    

    @Override
    public void setEditavel(boolean b) {}

    @Override
    public void limpar() {}
    
}

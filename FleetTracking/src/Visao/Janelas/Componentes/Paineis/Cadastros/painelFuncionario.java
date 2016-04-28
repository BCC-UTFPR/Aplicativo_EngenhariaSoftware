/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis.Cadastros;

import Visao.Janelas.Componentes.Campos.JLabelEditCpf;
import Visao.Janelas.Componentes.Campos.JLabelEditString;
import Visao.Janelas.Componentes.Campos.JLabelEditTextArea;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author MATHEUS-NOTE
 */
public class painelFuncionario extends JPanelCadastro {
    
    private JLabelEditString nome;
    private JLabelEditString numeroRegistro;
    private JLabelEditString numeroRG;
    private JLabelEditCpf numeroCPF;
    private JLabelEditString categoriaCNH;
    private JLabelEditTextArea comentarios;
    private JLabel labelTextArea;
    private JScrollPane sc;
    
    //private CadFuncionario dao;
    private String pesquisa = "nome";
    
    public painelFuncionario() throws ParseException  {
        
        nome = new JLabelEditString("Nome:", 5, 35, 400);
        numeroRegistro = new JLabelEditString("Número de Registro:", 5, 75, 200);
        numeroRG = new JLabelEditString("RG:", 215, 75, 200);
        numeroCPF = new JLabelEditCpf("CPF:", 430, 75, 200);
        comentarios = new JLabelEditTextArea();
        labelTextArea = new JLabel("Comentários:");
        labelTextArea.setBounds(10, 105, 100, 50);
        sc = new JScrollPane(comentarios);
        sc.setBounds(10, 140, 400, 50);
        
        this.add(nome);
        this.add(numeroRegistro);
        this.add(numeroRG);
        this.add(numeroCPF);
        this.add(labelTextArea);
        this.add(sc);
        
        setSize(500, 300);
        super.setClassEntity("CadFuncionario");
        super.setPesquisa(pesquisa);
    }  

    @Override
    public void setInstanceObj() {
        
        /*CadFuncionario cc = new CadFuncionario();

        if (this.getUpdate()){
            cc.setId(Long.parseLong(super.getId()));
        }
        cc.setNome(nome.getText());
        cc.setNumeroRegistro(numeroRegistro.getText());
        cc.setNumeroRG(numeroRG.getText());
        cc.setNumeroCPF(numeroCPF.getText());
        super.setObjEntity(cc);        
        */
        
    }

    @Override
    public void getInstanceObj(Object objSelect) {
        
        /*
        dao = (CadFuncionario) objSelect;
        super.setId(dao.getId()+"");
        this.setNome(dao.getNome());
        this.setNumeroRegistro(dao.getNumeroRegistro());
        this.setNumeroRG(dao.getNumeroRG());
        this.setNumeroCPF(dao.getNumeroCPF());
        */
        
    }

    public void setNome(String text) {
        this.nome.setText(text);
    }

    public void setNumeroRegistro(String text) {
        this.numeroRegistro.setText(text);
    }

    public void setNumeroRG(String text) {
        this.numeroRG.setText(text);
    }

    public void setNumeroCPF(String text) {
        this.numeroCPF.setText(text);
    }
    
    @Override
    public void setEditavel(boolean b) {
        if (!b) {
            this.comentarios.setEnabled(b);
        } else {
            this.comentarios.setEnabled(b);
        }
    }
    
    @Override
    public void limpar(){
        comentarios.setText("");
    }
}

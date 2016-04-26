/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis.Cadastros;

import Visao.Janelas.Componentes.Campos.JLabelEditCpf;
import Visao.Janelas.Componentes.Campos.JLabelEditString;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import java.text.ParseException;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author MATHEUS-NOTE
 */
public class painelFuncionario extends JPanelCadastro {
    
    private JLabelEditString nome;
    private JLabelEditString numeroRegistro;
    private JLabelEditString numeroRG;
    private JLabelEditCpf numeroCPF;
    //private JRadioButtonEdit categoriaCNH; criar a classe JRadioButtonEdit
    //private JTextAreaEdit comentarios; criar a classe JTextAreaEdit

    //private CadFuncionario dao;
    private String pesquisa = "nome";
    
    public painelFuncionario() throws ParseException  {
        
        nome = new JLabelEditString("Nome:", 5, 30, 400);
        numeroRegistro = new JLabelEditString("Número de Registro:", 5, 70, 100);
        numeroRG = new JLabelEditString("RG:", 160, 70, 100);
        numeroCPF = new JLabelEditCpf("CPF:", 315, 70, 100);
        
        this.add(nome);
        this.add(numeroRegistro);
        this.add(numeroRG);
        this.add(numeroCPF);
        
        setSize(500, 180);
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

    @Override
    public void setEditavel(boolean b) { }

    @Override
    public void limpar() { }

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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis.Cadastros;

import Persistencia.Database.CadFuncionario;
import Visao.Janelas.Componentes.Campos.JLabelEditCpf;
import Visao.Janelas.Componentes.Campos.JLabelEditString;
import Visao.Janelas.Componentes.Campos.JLabelEditTextArea;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.JCheckBox;

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
    private JCheckBox admistrador;
    
    private CadFuncionario dao;
    private String pesquisa = "nome";
    
    public painelFuncionario() throws ParseException  {
        
        nome = new JLabelEditString("*Nome:", 5, 35, 300, true);
        numeroRegistro = new JLabelEditString("*Número de Registro:", 325, 35, 300, true);
        numeroRG = new JLabelEditString("*RG:", 5, 75, 200, true);
        numeroCPF = new JLabelEditCpf("*CPF:", 215, 75, 200, true);
        categoriaCNH = new JLabelEditString("*CNH:", 425, 75, 200, true);
        comentarios = new JLabelEditTextArea("Comentários adicionais:", 5, 115, 620, false);
        admistrador = new JCheckBox("Administrador");
        admistrador.setLayout(null);
        admistrador.setBounds(50, 10, 150, 30);
        admistrador.setBackground(this.getBackground());
        
        this.add(nome);
        this.add(numeroRegistro);
        this.add(numeroRG);
        this.add(numeroCPF);
        this.add(categoriaCNH);
        this.add(comentarios);
        this.add(admistrador);
        
        setSize(500, 400);
        super.setClassEntity("CadFuncionario");
        super.setPesquisa(pesquisa);
    }  

    @Override
    public void setInstanceObj() {
        
        CadFuncionario cc = new CadFuncionario();

        if (this.getUpdate()){
            cc.setId(Long.parseLong(super.getId()));
        }
        cc.setNome(nome.getText());
        cc.setRegistro(numeroRegistro.getText());
        cc.setRg(numeroRG.getText());
        cc.setCpf(numeroCPF.getText());
        cc.setCnh(categoriaCNH.getText());
        cc.setComentarios(comentarios.getText());
        cc.setSenha(nome.getText().split(" ")[0]+numeroCPF.getText().split(".")[2]);
        cc.setAdm(admistrador.isSelected());
        cc.setAusente(false);
        cc.setSenha("mudar123");
        super.setObjEntity(cc);     
        
    }

    @Override
    public void getInstanceObj(Object objSelect) {
        
        dao = (CadFuncionario) objSelect;
        super.setId(dao.getId()+"");
        this.setNome(dao.getNome());
        this.setNumeroRegistro(dao.getRegistro());
        this.setNumeroCPF(dao.getCpf());
        this.setNumeroRG(dao.getRg());
        this.setCategoriaCNH(dao.getCnh());
        this.setAdm(dao.getAdm());
        this.setComentario(dao.getComentarios());
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
    
    public void setCategoriaCNH(String text) {
        this.categoriaCNH.setText(text);
    }
    
    private void setAdm(boolean adm) {
        this.admistrador.setSelected(adm);
    }
    
    @Override
    public void setEditavel(boolean b) {
        admistrador.setEnabled(b);
        admistrador.setBackground(this.getBackground());
    }
    
    @Override
    public void limpar(){
        admistrador.setSelected(false);
        admistrador.setBackground(this.getBackground());
    }

    @Override
    public boolean objValido(Object obj) {
    
        CadFuncionario f = (CadFuncionario) obj;
        
        return f.validar();
        
    }
    private void setComentario(String comentarios) {
        this.categoriaCNH.setText(comentarios);
    }
}

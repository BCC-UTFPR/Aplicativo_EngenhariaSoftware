/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis;

import Visao.Janelas.Componentes.Paineis.JPanelBase;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author jfilhogn
 */
public abstract class JPanelCadastro extends JPanelBase {

    private JLabel idCaption;
    private JLabel id;
    private Object ObjEntity;
    private String classEntity;
    private boolean aUpdate = false;
    private String pesquisa = "";

    public JPanelCadastro() {
        setLayout(null);
        
        idCaption = new JLabel("ID");
        id = new JLabel("[]");
        
        idCaption.setBounds(10, 0, 50, 50);
        id.setBounds(30, 0, 50, 50);
        
        idCaption.setFont(new java.awt.Font("Tahoma", 1, 14));
        id.setForeground(Color.red);
        
        
        this.add(idCaption);
        this.add(id);
        
    }

    public String getId() {
        return id.getText();
    }

    public void setId(String id) {
        this.id.setText(id);
    }

    public Object getObjEntity() {
        return ObjEntity;
    }

    public void setObjEntity(Object ObjEntity) {
        this.ObjEntity = ObjEntity;
    }

    public String getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(String classEntity) {
        this.classEntity = classEntity;
    }
    
    public abstract void setInstanceObj();
    public abstract void getInstanceObj(Object objSelect);
    public abstract void setEditavel(boolean b);
    public abstract void limpar();

    public void setUpdate(boolean b) {
        aUpdate = b;
    }
    
    public boolean getUpdate(){
        return aUpdate;
    }

    public String getPesquisa(){
        return pesquisa;
    }

    public void setPesquisa(String s){
        this.pesquisa = s;
    }

}

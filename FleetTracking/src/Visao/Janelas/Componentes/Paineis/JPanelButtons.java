/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Paineis;

import Visao.Janelas.Componentes.Paineis.JPanelBase;
import Persistencia.DAO;
import Visao.Janelas.Componentes.FormConsultaPadrao;
import Visao.Janelas.Componentes.JButtonBase;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author jfilhogn
 */
public class JPanelButtons extends JPanelBase{

    private JButtonBase btNew;
    private JButtonBase btSave;
    private JButtonBase btDelete;
    private JButtonBase btCancel;
    private JButtonBase btOpen;
    private JButtonBase btClose;
    private JPanelCadastro panelClient;
    private JFrame windowFrame;
    private DAO dao;
    private Object obj;
    private FormConsultaPadrao fcp;

    public JPanelButtons(JPanelCadastro panelClient, JFrame windowFrame) {
        
        this.setBackground(Color.orange);
        
        this.panelClient = panelClient;
        this.windowFrame = windowFrame;
        
        this.btNew    = new JButtonBase("Novo");
        this.btSave   = new JButtonBase("Salvar");
        this.btDelete = new JButtonBase("Excluir");
        this.btCancel = new JButtonBase("Cancelar");
        this.btOpen   = new JButtonBase("Abrir");
        this.btClose  = new JButtonBase("Fechar");

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paineis/cadastro/imageicons/Icone Novo.png")));
        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paineis/cadastro/imageicons/Icone Cancelar.png")));
        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paineis/cadastro/imageicons/Icone Abrir.png")));
        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paineis/cadastro/imageicons/Icone Deletar.png")));
        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paineis/cadastro/imageicons/Icone Salvar.png")));
        btClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paineis/cadastro/imageicons/Icone Fechar.png")));
        
        this.add(btNew);
        this.add(btSave);
        this.add(btDelete);
        this.add(btCancel);
        this.add(btOpen);
        this.add(btClose);
        
        initComponents();
        
    }
    
    public void OrganizeScreen(Object btBase){

        btNew.setEnabled(btBase.equals(btSave)||btBase.equals(btCancel)||btBase.equals(btDelete)||btBase.equals(this));
        btSave.setEnabled(btBase.equals(btNew)||btBase.equals(btOpen));
        btDelete.setEnabled(btBase.equals(btOpen));
        btCancel.setEnabled(btBase.equals(btNew)||btBase.equals(btOpen));
        btOpen.setEnabled(btBase.equals(btCancel)||btBase.equals(btSave)||btBase.equals(btDelete)||btBase.equals(this));
        btClose.setEnabled(btBase.equals(btSave)||btBase.equals(btDelete)||btBase.equals(btCancel)||btBase.equals(this));
        panelClient.setEnabled(btBase.equals(btNew)|| btBase.equals(btOpen));
        
        Boolean enabled;
        enabled = panelClient.isEnabled();

        for (int i = 0; i < panelClient.getComponentCount(); i++) {
           if(panelClient.getComponent(i) instanceof JLabelEdit){
                JLabelEdit component = (JLabelEdit) panelClient.getComponent(i);
                component.setEnabledField(enabled);
           }
        }

        panelClient.setEditavel(enabled);
        
        if (enabled){
            panelClient.setBackground(Color.WHITE);
        } else {
            panelClient.setBackground(Color.GRAY);
        }
    }

    private void initComponents() {
        
        windowFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);        

        btNew.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
                
                panelClient.setUpdate(false);
                OrganizeScreen(btNew);
            }
        });
        
        btSave.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panelClient.setInstanceObj();
                    obj = panelClient.getObjEntity();

                    dao = new DAO();

                    if (panelClient.getUpdate()) {
                        int opcao = JOptionPane.showOptionDialog(panelClient, "Deseja realmente alterar o arquivo?",
                        "Confirma Alteração", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new String[]{"Sim", "Nao"}, 1);
                        if (opcao == 0) {
                            try {
                                dao.update(obj);
                            } catch (Exception ex) {
                                Logger.getLogger(JPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    else {
                        dao.insert(obj);
                    }

                    limpar();
                    
                    panelClient.setUpdate(false);                    
                    OrganizeScreen(btSave);
                } catch (Exception ex) {
                    Logger.getLogger(JPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Ocorreu um erro ao tentar salvar o registro.");
                }
            }
        });
        
        btDelete.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {                
                try {
                    obj = panelClient.getObjEntity();

                    dao = new DAO();

                    int opcao = JOptionPane.showOptionDialog(panelClient, "Deseja realmente excluir o arquivo?",
                    "Confirma Exclusão", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new String[]{"Sim", "Nao"}, 1);
                    if (opcao == 0) {
                        try {
                            if (panelClient.getUpdate()) dao.delete(obj);
                        } catch (Exception ex) {
                            Logger.getLogger(JPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    limpar();

                    panelClient.setUpdate(false);                    
                    OrganizeScreen(btDelete);
                } catch (Exception ex) {
                    Logger.getLogger(JPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Ocorreu um erro ao tentar deletar o registro.");
                }
                
            }
        });

        btCancel.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
                
                panelClient.setUpdate(false);                
                OrganizeScreen(btCancel);
            }
        });
        
        btOpen.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dao = new DAO();
                    
                    String hqlQuery = "from "+panelClient.getClassEntity();
                          
                    List l = dao.select(hqlQuery);
                    
                    fcp = new FormConsultaPadrao("Consulta", l, panelClient);
                    fcp.setModal(true);
                    fcp.setVisible(true);                    
                    
                    if (panelClient.getUpdate()) OrganizeScreen(btOpen);                    
                } catch (Exception ex) {
                    Logger.getLogger(JPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btClose.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                windowFrame.dispose();
            }           
        });
    }

    private void limpar() {
        for(int i = 0; i < panelClient.getComponentCount(); i++){
            if (panelClient.getComponent(i) instanceof JLabelEdit){
                JLabelEdit component = (JLabelEdit) panelClient.getComponent(i);
                component.setText("");
                component.setLabel("");
            }
        }
        panelClient.setId("[]");
        panelClient.limpar();
    }
}

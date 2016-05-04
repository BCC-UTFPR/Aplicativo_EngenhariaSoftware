/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes;

import Persistencia.DAO;
import Persistencia.DAOInterface;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import Visao.Janelas.Componentes.Paineis.JPanelGrid;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author jfilhogn
 */
public class FormConsultaPadrao extends JDialog {

    private JPanelGrid panelGrid;
    private List lista;
    private javax.swing.JLabel jLabel1;
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private javax.swing.JButton btOk;
    private javax.swing.JButton btCancelar;
    private JTextFieldBase pesquisar;
    private JPanelCadastro aPanelClient;
    private javax.swing.JScrollPane panelScroll = new JScrollPane();
    private DAO dao;
    private String text;
    private String pesquisa;
    private boolean sera;
    private Object objSelect;

    public FormConsultaPadrao(String title, List l, JPanelCadastro panelClient) throws ParseException {
        super.setTitle(title);
        super.setSize(500,500);

        sera = true;
        lista = l;
        aPanelClient = panelClient;
        panelGrid = new JPanelGrid(lista);
        panelGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jLabel1 = new javax.swing.JLabel();
        btOk = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pesquisar = new JTextFieldBase("");
        pesquisar.addKeyListener(new KeyListener(){
            @Override
                public void keyPressed(KeyEvent arg0) { }

            @Override
               public void keyReleased(KeyEvent arg0) { 
                   try {
                       if (dao == null){
                        dao = new DAO();
                       }

                       String hqlQuery = "from "+aPanelClient.getClassEntity()+" where "+aPanelClient.getPesquisa()+" like '%"+this.getPesquisa()+"%'";

                       lista = dao.select(hqlQuery);

                   } catch (Exception ex) {
                        Logger.getLogger(FormConsultaPadrao.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   if (!lista.isEmpty()){
                        panelGrid.atualiza(lista);
                   }
               }
            @Override
               public void keyTyped(KeyEvent arg0) {
                }

                private String getPesquisa() {
                    return pesquisar.getText();
                }

        });


        panelGrid.setSize(500, 380);

        jLabel1.setText("Pesquisar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(btOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        jPanel2.setBackground(Color.orange);
        panelScroll.setViewportView(panelGrid);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(panelScroll, java.awt.BorderLayout.CENTER);

        pack();
    }

    public FormConsultaPadrao(String title, List l, String s, String p) throws ParseException {
        super.setTitle(title);
        super.setSize(500,500);

        sera = false;
        lista = l;
        text = s;
        pesquisa = p;
        panelGrid = new JPanelGrid(lista);
        panelGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jLabel1 = new javax.swing.JLabel();
        btOk = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pesquisar = new JTextFieldBase("");
        pesquisar.addKeyListener(new KeyListener(){
            @Override
                public void keyPressed(KeyEvent arg0) { }

            @Override
               public void keyReleased(KeyEvent arg0) {
                   try {
                       if (dao == null){
                        dao = new DAO();
                       }

                       String hqlQuery = "from "+text+" where "+pesquisa+" like '%"+this.getPesquisa()+"%'";

                       lista = dao.select(hqlQuery);

                   } catch (Exception ex) {
                        Logger.getLogger(FormConsultaPadrao.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   if (!lista.isEmpty()){
                        panelGrid.atualiza(lista);
                   }
               }
            @Override
               public void keyTyped(KeyEvent arg0) {
                }

                private String getPesquisa() {
                    return pesquisar.getText();
                }

        });


        panelGrid.setSize(500, 380);

        jLabel1.setText("Pesquisar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(btOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        jPanel2.setBackground(Color.orange);
        panelScroll.setViewportView(panelGrid);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(panelScroll, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
        actionReturnEvent();
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public String getPesquisa(){
        return pesquisar.getText();
    }

    private Object getSelecionado() {
        int index = panelGrid.getSelectedRow();
        return lista.get(index);
    }

    public Object getReferencia(){
        return objSelect;
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        actionReturnEvent();
    }
    
    private void actionReturnEvent() {
        try {
            if (sera) {
                objSelect = getSelecionado();
                aPanelClient.getInstanceObj(objSelect);
                aPanelClient.setObjEntity(objSelect);
                aPanelClient.setUpdate(true);
                this.dispose();
            } else {
                objSelect = (DAOInterface) getSelecionado();
                this.dispose();
            }

        } catch (Exception ex) {
            Logger.getLogger(FormConsultaPadrao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


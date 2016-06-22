/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Campos;

import Persistencia.DAO;
import Persistencia.DAOInterface;
import Visao.Janelas.FormConsultaPadrao;
import Visao.Janelas.Componentes.JTextFieldBase;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author vinicius
 */
public class JLabelEdit extends JComponent {

    protected JTextFieldBase campo;
    private JLabel label;
    private JButton botton;
    private JLabel rotulo;
    private String mascara;
    private String caption;
    private DAOInterface obj = null;
    private DAO dao;
    private FormConsultaPadrao fcp;
    private String tabela;
    private String pesquisa;
    private boolean permicao;
    private boolean look;
    
    public JLabelEdit(String caption, int left, int top, int width, Boolean showMask, boolean b, String table, String pes, boolean obrigatorio) throws ParseException {
        
        this.setLayout(null);
        this.setBounds(left, top, (width+10), 50);
        
        
        if (showMask){
            mascara = "";
        }

        if (b) {
            permicao = b;
            pesquisa = pes;
            tabela = table;
            campo = new JTextFieldBase(mascara);
            campo.setBounds(5, 20, 40, 20);
//            bug
//            campo.addMouseListener(new java.awt.event.MouseAdapter() { 
//                @Override
//                public void mouseClicked(java.awt.event.MouseEvent evt) {
//                    if (campo.isEnabled()) {
//                        jFormattedTextField1MouseClicked(evt);
//                    }
//                }
//            });
            campo.addKeyListener(new KeyListener(){
                @Override
                    public void keyPressed(KeyEvent arg0) {
                        procura();
                    }
                        
                @Override
                   public void keyReleased(KeyEvent arg0) {
//                        actionSelected();
                        procura();
                   }
                @Override
                   public void keyTyped(KeyEvent arg0) { }
            });
            campo.addFocusListener(new java.awt.event.FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    setBackground(Color.YELLOW);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    setBackground(Color.WHITE);
                    
//                    try {
//                       if (dao == null){
//                        dao = new DAO();
//                       }
//
//                       String hqlQuery = "from "+tabela+" where ID="+this.getPesquisa()+"";
//
//                       List lista = dao.select(hqlQuery);
//
//                       DAOInterface obj = (DAOInterface) lista.get(0);
//
//                       if (lista.get(0).equals(null)) {
//                            label.setText("Não Exite");
//                       } else label.setText(obj.getReferencia());
//
//
//                   } catch (Exception ex) {
//                        Logger.getLogger(FormConsultaPadrao.class.getName()).log(Level.SEVERE, null, ex);
//                   }
                }
            });
            botton = new JButton("?");
            botton.setBounds(60, 20, 50, 20);
            botton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                }
            });
            label = new JLabel();
            label.setBounds(120, 20, 200, 20);
            label.setText("");

            this.add(botton);
            this.add(label);
        } else {
            campo = new JTextFieldBase(mascara);
            campo.setBounds(5, 20, width, 20);
        }
        this.caption = caption;

        rotulo = new JLabel(caption);
        rotulo.setBounds(5, 2, width, 20);
        
        setObrigatoriedade(obrigatorio);
        
        this.add(rotulo);
        this.add(campo);
        
    }
    
    public void setObrigatoriedade(boolean obrigatorio) {
        campo.setObrigatoriedade(obrigatorio);
        campo.setMenssagem(caption);
    }

    public void setLabel(String a){
        if (permicao) {
            this.label.setText(a);
        }
    }

    public String getLabel(){
        return label.getText();
    }

    public String getRotulo(){
        return caption;
    }

    public String getText() {
        return this.campo.getText();
    }

    public void setText(String campo) {
        this.campo.setText(campo);
    }

    public void setMask(String s){
        this.campo.setMask(s);
    }

    public void setEnabledField(boolean b) {
        this.campo.setEnabled(b);
        if (permicao) {
            this.botton.setEnabled(b);
        }
    }

    private void jFormattedTextField1MouseClicked(java.awt.event.MouseEvent evt) {
        actionSelected();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        actionSelected();
    }
    
    public DAOInterface getReferancia() {
        return obj;
    }
    
    public void setReferancia(DAOInterface obj) {
        this.obj = obj;
        campo.setText(""+obj.getId());
        label.setText(obj.getReferencia());
    }
    
    private void actionSelected() {
        try {
            if (dao == null){
                dao = new DAO();
            }

            String hqlQuery = "from "+tabela;

            List l = dao.select(hqlQuery);

            fcp = new FormConsultaPadrao("Consulta", l, tabela, pesquisa);
            fcp.setModal(true);
            fcp.setVisible(true);
            obj = (DAOInterface) fcp.getReferencia();
            campo.setText(""+obj.getId());
            label.setText(obj.getReferencia());

        } catch (Exception ex) {
            Logger.getLogger(JLabelEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getPesquisa() {
        return campo.getText();
    }
    
    private void procura(){
        try {
           if (dao == null){
            dao = new DAO();
           }

           String hqlQuery = "from "+tabela+" where ID="+this.getPesquisa()+"";

           List lista = dao.select(hqlQuery);

           DAOInterface obj = (DAOInterface) lista.get(0);

           if (lista.get(0).equals(null)) {
                label.setText("Não Exite");
           } else label.setText(obj.getReferencia());


       } catch (Exception ex) {
            Logger.getLogger(FormConsultaPadrao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
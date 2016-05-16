/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.Document;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

/**

/**
 *
 * @author vinicius
 */
public class JTextFieldBase extends JFormattedTextField {

    private boolean permicao;
    private boolean obrigatorio;
    private String descricao;

    public JTextFieldBase(String mascara) {
        
        super(mascara);
        
        this.addFocusListener(new java.awt.event.FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                setBackground(Color.YELLOW);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(Color.WHITE);
                //testaPreenchimento();
            }
            
        });
        
    }
    
    public void setPermicao(boolean b){
        permicao = b;
    }
    
    public void setObrigatoriedade(boolean b){
        obrigatorio = b;
    }
    
    public void setMenssagem(String s) {
        descricao = s;
    }
    
    private void testaPreenchimento() {
        if (obrigatorio)
            if (super.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo "+descricao+" é um campo obrigatório");
            }
    }
    
    @Override
    protected Document createDefaultModel() {
        if (permicao) return new LowerCaseDocument();
        return new UpperCaseDocument();
    }
 
    static class UpperCaseDocument extends PlainDocument {
 
        @Override
         public void insertString(int offs, String str, AttributeSet a) 
             throws BadLocationException {
 
             if (str == null) {
                 return;
             }
             char[] upper = str.toCharArray();
             for (int i = 0; i < upper.length; i++) {
                 upper[i] = Character.toUpperCase(upper[i]);
             }
             super.insertString(offs, new String(upper), a);
         }
    }

    static class LowerCaseDocument extends PlainDocument {

        @Override
         public void insertString(int offs, String str, AttributeSet a)
             throws BadLocationException {

             if (str == null) {
                 return;
             }
             char[] lower = str.toCharArray();
             for (int i = 0; i < lower.length; i++) {
                 lower[i] = Character.toLowerCase(lower[i]);
             }
             super.insertString(offs, new String(lower), a);
         }
    }


    public void setMask(String s) {
        try {
            this.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(s)));
        } catch (ParseException ex) {
            Logger.getLogger(JTextFieldBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


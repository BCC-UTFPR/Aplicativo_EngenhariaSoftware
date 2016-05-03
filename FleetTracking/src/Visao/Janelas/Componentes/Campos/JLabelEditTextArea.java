/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Campos;

import Visao.Janelas.Componentes.JTextAreaBase;
import java.awt.Color;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author MATHEUS-NOTE
 */
public class JLabelEditTextArea extends JComponent {
    
    private JLabel rotulo;
    private JScrollPane sc;
    private JTextAreaBase campo;
    private String caption;
    private boolean permicao;

    public JLabelEditTextArea(String caption, int left, int top, int width, boolean b) {

        this.setLayout(null);
        this.setBounds(left, top, (width+10), 140);
        
        permicao = b;
        
        campo = new JTextAreaBase();
        
        sc = new JScrollPane(campo);
        sc.setBounds(5, 20, width, 120);
        
        this.caption = caption;

        rotulo = new JLabel(caption);
        rotulo.setBounds(5, 2, width, 20);
        
        this.add(rotulo);
        this.add(sc);

    }

    public String getText() {
        return this.campo.getText();
    }

    public void setText(String campo) {
        this.campo.setText(campo);
    }
    
    public void setEnabledField(boolean b) {
        this.campo.setEnabled(b);
    }
}

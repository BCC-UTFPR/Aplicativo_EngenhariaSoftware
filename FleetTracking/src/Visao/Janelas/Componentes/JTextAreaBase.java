/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao.Janelas.Componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author MATHEUS-NOTE
 */
public class JTextAreaBase extends JTextArea {

    public JTextAreaBase() {
        this.addFocusListener(new java.awt.event.FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                setBackground(Color.YELLOW);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(Color.WHITE);
            }

        });

    }

    @Override
    protected Document createDefaultModel() {
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Campos;

import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class JLabelEditCpf extends JLabelEdit{

    public JLabelEditCpf(String caption, int left, int top, int width) throws ParseException {
        super(caption, left, top, width, true, false, null, null);
        super.setMask("###.###.###-##");
        
        super.campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (true/*!ValidaCPF()*/){
                    JOptionPane.showMessageDialog(null, "Atenção! CPF inválido.");                    
                }
            }
        });        
        
    }
}

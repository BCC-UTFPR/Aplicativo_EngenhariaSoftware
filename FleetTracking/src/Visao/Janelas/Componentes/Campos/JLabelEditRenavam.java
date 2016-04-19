/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Campos;

import Serviços.ValidadorRenavam;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class JLabelEditRenavam extends JLabelEdit{

    public JLabelEditRenavam(String caption, int left, int top, int width) throws ParseException {
        super(caption, left, top, width, true, false, null, null);
        
        super.campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (!new ValidadorRenavam().validarRenavam(campo.getText())){
                    JOptionPane.showMessageDialog(null, "Atenção! CPF inválido.");                    
                }
            }
        });        
        
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Campos;

import Serviços.ValidaCPF;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class JLabelEditCpf extends JLabelEdit{

    public JLabelEditCpf(String caption, int left, int top, int width, boolean obrigatorio) throws ParseException {
        super(caption, left, top, width, true, false, null, null, obrigatorio);
        super.setMask("###.###.###-##");
        
        super.campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (!new ValidaCPF().validar(campo.getText())){
                    JOptionPane.showMessageDialog(null, "Atenção! CPF inválido.");                    
                }
            }
        });        
        
    }
}

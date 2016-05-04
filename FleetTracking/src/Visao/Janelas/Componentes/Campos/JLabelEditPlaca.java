/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Campos;

import java.text.ParseException;

/**
 *
 * @author vinicius
 */
public class JLabelEditPlaca extends JLabelEdit {

    public JLabelEditPlaca(String caption, int left, int top, int width, boolean obrigatorio) throws ParseException {
        super(caption, left, top, width, true, false, null, null, obrigatorio);
        super.setMask("???-####");
    }    
}

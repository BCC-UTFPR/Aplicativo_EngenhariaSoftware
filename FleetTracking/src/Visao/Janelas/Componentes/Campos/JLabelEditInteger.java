/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Componentes.Campos;

import java.text.ParseException;

/**
 *
 * @author MATHEUS-NOTE
 */
public class JLabelEditInteger extends JLabelEdit {
    private String mask1 = "";

    public JLabelEditInteger(String caption, int left, int top, int width, boolean b, String mask, boolean obrigatorio) throws ParseException {
        super(caption, left, top, width, b, false, null, null, obrigatorio);
        if (b){
            this.mask1 = mask;
            super.setMask(mask1);
        }
    }
}

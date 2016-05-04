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
public class JLabelEditString extends JLabelEdit{

    public JLabelEditString(String caption, int left, int top, int width, boolean obrigatorio) throws ParseException {
        super(caption, left, top, width, false, false, null, null, obrigatorio);
    }
}
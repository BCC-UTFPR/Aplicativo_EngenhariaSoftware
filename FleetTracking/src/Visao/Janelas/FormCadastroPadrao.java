/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas;

import Visao.Janelas.Componentes.Paineis.JPanelButtons;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import javax.swing.JFrame;
/**
 *
 * @author jfilhogn
 */
public class FormCadastroPadrao extends JFrame {

    private JPanelButtons panelBotton;   
    
    public FormCadastroPadrao(JPanelCadastro panelClient, String title) {
        super.setTitle(title);

        this.panelBotton = new JPanelButtons(panelClient, this);
        
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        
        setBounds((screenSize.width-566)/2, (screenSize.height-216)/2, 655, panelClient.getHeight());
        
        getContentPane().add(panelClient, java.awt.BorderLayout.CENTER);
        getContentPane().add(panelBotton, java.awt.BorderLayout.SOUTH);
        
        panelBotton.OrganizeScreen(panelBotton);

    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Janelas.Principal;

import Visao.Janelas.Componentes.Paineis.Cadastros.painelFuncionario;
import Visao.Janelas.Componentes.Paineis.Cadastros.painelVeiculo;
import Visao.Janelas.Componentes.Paineis.JPanelCadastro;
import Visao.Janelas.FormCadastroPadrao;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MATHEUS-NOTE
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar = new javax.swing.JMenuBar();
        jMenuIniciar = new javax.swing.JMenu();
        jMenuIniciarSair = new javax.swing.JMenuItem();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadastroFuncionario = new javax.swing.JMenuItem();
        jMenuCadastroVeiculo = new javax.swing.JMenuItem();
        jMenuViagem = new javax.swing.JMenu();
        jMenuViagemIniciar = new javax.swing.JMenuItem();
        jMenuViagemFinalizar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jMenuIniciar.setText("Iniciar");

        jMenuIniciarSair.setText("Sair");
        jMenuIniciarSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIniciarSairActionPerformed(evt);
            }
        });
        jMenuIniciar.add(jMenuIniciarSair);

        jMenuBar.add(jMenuIniciar);

        jMenuCadastro.setText("Cadastro");

        jMenuCadastroFuncionario.setText("Cadastrar Funcionário");
        jMenuCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadastroFuncionario);

        jMenuCadastroVeiculo.setText("Cadastrar Veículo");
        jMenuCadastroVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroVeiculoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadastroVeiculo);

        jMenuBar.add(jMenuCadastro);

        jMenuViagem.setText("Viagem");

        jMenuViagemIniciar.setText("Iniciar Viagem");
        jMenuViagem.add(jMenuViagemIniciar);

        jMenuViagemFinalizar.setText("Finalizar Viagem");
        jMenuViagem.add(jMenuViagemFinalizar);

        jMenuBar.add(jMenuViagem);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuIniciarSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIniciarSairActionPerformed
        sair();
    }//GEN-LAST:event_jMenuIniciarSairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        sair();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sair();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroFuncionarioActionPerformed
        painel = null;
        try {
            painel = new painelFuncionario();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        FormCadastroPadrao FormPropriedade = new FormCadastroPadrao(painel, "Cadastro de Funcionário");
        FormPropriedade.setVisible(true);
    }//GEN-LAST:event_jMenuCadastroFuncionarioActionPerformed

    private void jMenuCadastroVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroVeiculoActionPerformed
        painel = null;
        try {
            painel = new painelVeiculo();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        FormCadastroPadrao FormPropriedade = new FormCadastroPadrao(painel, "Cadastro de Veículo");
        FormPropriedade.setVisible(true);
    }//GEN-LAST:event_jMenuCadastroVeiculoActionPerformed
    
    private void sair() {
        int opcao = JOptionPane.showOptionDialog(this, "Deseja realmente sair?",
                "Confirma saida", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Sim", "Nao"}, 1);
        if (opcao == 0) {
            System.exit(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuCadastroFuncionario;
    private javax.swing.JMenuItem jMenuCadastroVeiculo;
    private javax.swing.JMenu jMenuIniciar;
    private javax.swing.JMenuItem jMenuIniciarSair;
    private javax.swing.JMenu jMenuViagem;
    private javax.swing.JMenuItem jMenuViagemFinalizar;
    private javax.swing.JMenuItem jMenuViagemIniciar;
    // End of variables declaration//GEN-END:variables
    private JPanelCadastro painel;
    private FleetTracking ft;

}

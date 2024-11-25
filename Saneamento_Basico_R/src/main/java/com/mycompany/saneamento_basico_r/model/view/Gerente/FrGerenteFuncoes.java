/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.saneamento_basico_r.model.view.Gerente;

import com.mycompany.saneamento_basico_r.model.view.Adminisctrador.*;
import com.mycompany.saneamento_basico_r.model.view.Cliente.FrClienteHistoricoConsumo;
import com.mycompany.saneamento_basico_r.model.view.Cliente.FrClientePendencias;
import com.mycompany.saneamento_basico_r.controller.ClienteController;
import com.mycompany.saneamento_basico_r.model.view.FrEmpresaSaneamento;
import com.mycompany.saneamento_basico_r.model.view.Planos.FrPlanosEscolher;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author joserui
 */
public class FrGerenteFuncoes extends javax.swing.JDialog {

    ClienteController clienteController;
    Long idClienteEditando;

    public FrGerenteFuncoes(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        
        clienteController = new ClienteController();

        initComponents();

        /*this.habilitarCampos(false);
        this.limparCampos();*/

        //edtListagem.setText(profController.imprimirListaProfessores());
        //clienteController.atualizarTabela(grdClientes);
    }

    /*public void habilitarCampos(boolean flag) {
        for (int i = 0; i < panFormulario.getComponents().length; i++) {
            panFormulario.getComponent(i).setEnabled(flag);
        }
    }

    public void limparCampos() {
        edtNome.setText("");
        edtSexo.setText("");
        edtIdade.setText("");
        fEdtMatricula.setText("");
    }*/ 

    /**
     * O ideal seria entregar essa responsabiliadde para o controller para isso
     * deveriamos passar os componentes edt s
     *
     * OU senao criar um novo tipo representationModel, que será a representacao
     * do modelo na camada VIEW. Com isso criamos uma independencia da camada
     * MODEL.
     *
     * @param a
     */
    /*public void preencherFormulario(Cliente a) {
        edtNome.setText(a.getNome());
        edtSexo.setText(a.getSexo() + "");
        edtIdade.setText(a.getIdade() + "");
        fEdtMatricula.setText(a.getMatricula());
        edtAno.setText(a.getAnoIngresso() + "");
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGerente = new javax.swing.JLabel();
        btnSuporte = new javax.swing.JButton();
        btnManutencao = new javax.swing.JButton();
        btnAdicionarEmpresas = new javax.swing.JButton();
        btnGerarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Alunos");

        lblGerente.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblGerente.setText("Funções Gerente");

        btnSuporte.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSuporte.setText("Suporte Tecnico");
        btnSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuporteActionPerformed(evt);
            }
        });

        btnManutencao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManutencao.setText("Enviar aviso de manutenção de sistema");
        btnManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManutencaoActionPerformed(evt);
            }
        });

        btnAdicionarEmpresas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAdicionarEmpresas.setText("Adicionar Empresas de Saneamento no Sistema");
        btnAdicionarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEmpresasActionPerformed(evt);
            }
        });

        btnGerarRelatorio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnGerarRelatorio.setText("Gerar Relatório de Contas e Faturas");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnManutencao)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdicionarEmpresas)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGerarRelatorio)
                                .addGap(45, 45, 45)))
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblGerente)
                        .addGap(248, 248, 248))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSuporte)
                        .addGap(259, 259, 259))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnSuporte)
                .addGap(18, 18, 18)
                .addComponent(btnManutencao)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionarEmpresas)
                .addGap(18, 18, 18)
                .addComponent(btnGerarRelatorio)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManutencaoActionPerformed
        FrAdministradorAvisoManutencao dlgAvisoManutencao = new FrAdministradorAvisoManutencao(this, true);
        
        dlgAvisoManutencao.setLocationRelativeTo(this);
        dlgAvisoManutencao.setVisible(true);
    }//GEN-LAST:event_btnManutencaoActionPerformed

    private void btnAdicionarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEmpresasActionPerformed
        FrEmpresaSaneamento dlgEmpresaSaneamento = new FrEmpresaSaneamento(this, true);
        
        dlgEmpresaSaneamento.setLocationRelativeTo(this);
        dlgEmpresaSaneamento.setVisible(true);
    }//GEN-LAST:event_btnAdicionarEmpresasActionPerformed

    private void btnSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuporteActionPerformed
        
    }//GEN-LAST:event_btnSuporteActionPerformed

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    /**
     * Retorna o objeto (classe) da linha selecionada na grid.
     *
     * Uso a estratégia do metodo getValueAt() la na TableModel, receber coluna
     * -1 e retornar o objeto ao inves de uma célula.
     *
     * @return
     */
    /*private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdAlunos.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdAlunos.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarEmpresas;
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton btnManutencao;
    private javax.swing.JButton btnSuporte;
    private javax.swing.JLabel lblGerente;
    // End of variables declaration//GEN-END:variables
}
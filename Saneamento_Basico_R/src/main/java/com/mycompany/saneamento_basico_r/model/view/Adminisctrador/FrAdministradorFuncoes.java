/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.saneamento_basico_r.model.view.Adminisctrador;

import com.mycompany.saneamento_basico_r.model.view.Cliente.FrClienteHistoricoConsumo;
import com.mycompany.saneamento_basico_r.model.view.Cliente.FrClientePendencias;
import com.mycompany.saneamento_basico_r.controller.ClienteController;
import com.mycompany.saneamento_basico_r.model.view.Planos.FrPlanosEscolher;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import com.mycompany.saneamento_basico_r.model.view.CadastrarEmpresa.FrCadastroEmpresaSaneamento;

/**
 *
 * @author joserui
 */
public class FrAdministradorFuncoes extends javax.swing.JDialog {

    ClienteController clienteController;
    Long idClienteEditando;

    public FrAdministradorFuncoes(java.awt.Dialog parent, boolean modal) {
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

        lblAdministrador = new javax.swing.JLabel();
        btnSuporte = new javax.swing.JButton();
        btnManutencao = new javax.swing.JButton();
        btnCadastrarRede = new javax.swing.JButton();
        btnAdicionarPlanos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Alunos");

        lblAdministrador.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblAdministrador.setText("Funções Adiministrador");

        btnSuporte.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSuporte.setText("Suporte Tecnico");
        btnSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuporteActionPerformed(evt);
            }
        });

        btnManutencao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManutencao.setText("Manutenção do Sistema");
        btnManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManutencaoActionPerformed(evt);
            }
        });

        btnCadastrarRede.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCadastrarRede.setText("Cadastrar Rede de Saneamento");
        btnCadastrarRede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarRedeActionPerformed(evt);
            }
        });

        btnAdicionarPlanos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAdicionarPlanos.setText("Adicionar Planos");
        btnAdicionarPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPlanosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSuporte)
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnManutencao)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdicionarPlanos)
                        .addGap(263, 263, 263))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAdministrador)
                            .addComponent(btnCadastrarRede))
                        .addGap(189, 189, 189))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManutencao)
                .addGap(12, 12, 12)
                .addComponent(btnCadastrarRede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionarPlanos)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManutencaoActionPerformed
        FrAdministradorAvisoManutencao dlgAvisoManutencao = new FrAdministradorAvisoManutencao(this, true);
        
        dlgAvisoManutencao.setLocationRelativeTo(this);
        dlgAvisoManutencao.setVisible(true);
    }//GEN-LAST:event_btnManutencaoActionPerformed

    private void btnCadastrarRedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarRedeActionPerformed
        FrCadastroEmpresaSaneamento dlgEmpresaSaneamento = new FrCadastroEmpresaSaneamento(this, true);
        
        dlgEmpresaSaneamento.setLocationRelativeTo(this);
        dlgEmpresaSaneamento.setVisible(true);
    }//GEN-LAST:event_btnCadastrarRedeActionPerformed

    private void btnSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuporteActionPerformed
        
    }//GEN-LAST:event_btnSuporteActionPerformed

    private void btnAdicionarPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPlanosActionPerformed
        FrCadastroEmpresaSaneamento dlgEmpresaSaneamento = new FrCadastroEmpresaSaneamento(this, true);

        dlgEmpresaSaneamento.setLocationRelativeTo(this);
        dlgEmpresaSaneamento.setVisible(true);
    }//GEN-LAST:event_btnAdicionarPlanosActionPerformed

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
    private javax.swing.JButton btnAdicionarPlanos;
    private javax.swing.JButton btnCadastrarRede;
    private javax.swing.JButton btnManutencao;
    private javax.swing.JButton btnSuporte;
    private javax.swing.JLabel lblAdministrador;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.saneamento_basico_r.model.view.Funcionario;

import com.mycompany.saneamento_basico_r.controller.ClienteController;
import com.mycompany.saneamento_basico_r.model.view.RecuperarSenha.FrRecuperarSenha;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author joserui
 */
public class FrFuncionario extends javax.swing.JDialog {

    ClienteController clienteController;
    Long idClienteEditando;

    public FrFuncionario(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        
        clienteController = new ClienteController();

        initComponents();
        this.adicionarMascaraNosCampos();

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

    public void adicionarMascaraNosCampos() {
        try {
            // Precisa começar com uma letra, depois pode ser letra ou numero
            MaskFormatter maskUsuario = new MaskFormatter("?AAAAAAAAAAAAAAAAAAA");
            maskUsuario.install(fFuncionarioUsuario);                                    
        } catch (ParseException ex) {
            Logger.getLogger(FrFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

        lblLoginFuncionario = new javax.swing.JLabel();
        lblFuncionarioUsuario = new javax.swing.JLabel();
        fFuncionarioUsuario = new javax.swing.JFormattedTextField();
        lblFuncionarioSenha = new javax.swing.JLabel();
        fFuncionarioSenha = new javax.swing.JFormattedTextField();
        btnUsuarioLogin = new javax.swing.JButton();
        lblFuncionarioRegistrar = new javax.swing.JLabel();
        btnUsuarioRegistrar = new javax.swing.JButton();
        btnSenhaEsqueci = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Alunos");

        lblLoginFuncionario.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLoginFuncionario.setText("Login Funcionario");

        lblFuncionarioUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioUsuario.setText("Usuário:");

        fFuncionarioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioUsuarioActionPerformed(evt);
            }
        });

        lblFuncionarioSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioSenha.setText("Senha:");

        fFuncionarioSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioSenhaActionPerformed(evt);
            }
        });

        btnUsuarioLogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnUsuarioLogin.setText("Login");
        btnUsuarioLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioLoginActionPerformed(evt);
            }
        });

        lblFuncionarioRegistrar.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblFuncionarioRegistrar.setText("Não tem uma conta? Faça seu registro clicando no botão:");

        btnUsuarioRegistrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnUsuarioRegistrar.setText("Registrar");
        btnUsuarioRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioRegistrarActionPerformed(evt);
            }
        });

        btnSenhaEsqueci.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btnSenhaEsqueci.setText("Esqueci a senha");
        btnSenhaEsqueci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenhaEsqueciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFuncionarioUsuario)
                    .addComponent(lblFuncionarioSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnUsuarioLogin))
                    .addComponent(fFuncionarioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fFuncionarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSenhaEsqueci)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnUsuarioRegistrar)
                                .addGap(85, 85, 85))
                            .addComponent(lblFuncionarioRegistrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLoginFuncionario)
                        .addGap(256, 256, 256))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblLoginFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSenhaEsqueci))
                .addGap(18, 18, 18)
                .addComponent(btnUsuarioLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(lblFuncionarioRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarioRegistrar)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioRegistrarActionPerformed
        FrFuncionarioCadastro dlgRegistrarFuncionario = new FrFuncionarioCadastro(this, true);
        
        dlgRegistrarFuncionario.setLocationRelativeTo(this);
        dlgRegistrarFuncionario.setVisible(true);
    }//GEN-LAST:event_btnUsuarioRegistrarActionPerformed

    private void fFuncionarioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioUsuarioActionPerformed

    private void fFuncionarioSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioSenhaActionPerformed

    private void btnSenhaEsqueciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenhaEsqueciActionPerformed
        FrRecuperarSenha dlgRecuperarSenha = new FrRecuperarSenha(this, true);
        
        dlgRecuperarSenha.setLocationRelativeTo(this);
        dlgRecuperarSenha.setVisible(true);
    }//GEN-LAST:event_btnSenhaEsqueciActionPerformed

    private void btnUsuarioLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioLoginActionPerformed
        FrFuncionarioFuncoes dlgFuncoes = new FrFuncionarioFuncoes(this, true);
        
        dlgFuncoes.setLocationRelativeTo(this);
        dlgFuncoes.setVisible(true);
        
    }//GEN-LAST:event_btnUsuarioLoginActionPerformed

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
    private javax.swing.JButton btnSenhaEsqueci;
    private javax.swing.JButton btnUsuarioLogin;
    private javax.swing.JButton btnUsuarioRegistrar;
    private javax.swing.JFormattedTextField fFuncionarioSenha;
    private javax.swing.JFormattedTextField fFuncionarioUsuario;
    private javax.swing.JLabel lblFuncionarioRegistrar;
    private javax.swing.JLabel lblFuncionarioSenha;
    private javax.swing.JLabel lblFuncionarioUsuario;
    private javax.swing.JLabel lblLoginFuncionario;
    // End of variables declaration//GEN-END:variables
}

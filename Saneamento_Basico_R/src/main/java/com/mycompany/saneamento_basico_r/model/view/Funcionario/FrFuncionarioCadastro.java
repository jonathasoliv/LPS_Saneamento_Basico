/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.view.Funcionario;

/**
 *
 * @author Guize
 */
public class FrFuncionarioCadastro extends javax.swing.JDialog {

    /**
     * Creates new form CadastroCliente2
     */
    public FrFuncionarioCadastro(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
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

        lblLoginFuncionario = new javax.swing.JLabel();
        fFuncionarioNome = new javax.swing.JFormattedTextField();
        lblFuncionarioNome = new javax.swing.JLabel();
        lblFuncionarioSexo = new javax.swing.JLabel();
        fFuncionarioSexo = new javax.swing.JFormattedTextField();
        btnFuncionarioRegistrar = new javax.swing.JButton();
        fFuncionarioNascimento = new javax.swing.JFormattedTextField();
        lblFuncionarioNascimento = new javax.swing.JLabel();
        lblFuncionarioEndereco = new javax.swing.JLabel();
        fFuncionarioEndereco = new javax.swing.JFormattedTextField();
        fFuncionarioTelefone = new javax.swing.JFormattedTextField();
        lblFuncionarioSenha = new javax.swing.JLabel();
        fFuncionarioSenha = new javax.swing.JFormattedTextField();
        lblFuncionarioUsuario = new javax.swing.JLabel();
        fFuncionarioUsuario = new javax.swing.JFormattedTextField();
        lblFuncionarioCPF = new javax.swing.JLabel();
        fFuncionarioCPF = new javax.swing.JFormattedTextField();
        lblFuncionarioCidade = new javax.swing.JLabel();
        fFuncionarioCidade = new javax.swing.JFormattedTextField();
        lblFuncionarioTelefone = new javax.swing.JLabel();
        fFuncionarioEmail = new javax.swing.JFormattedTextField();
        lblFuncionarioEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblLoginFuncionario.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLoginFuncionario.setText("Cadastro de Funcionario");

        fFuncionarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioNomeActionPerformed(evt);
            }
        });

        lblFuncionarioNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioNome.setText("Nome:");

        lblFuncionarioSexo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioSexo.setText("Sexo:");

        fFuncionarioSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioSexoActionPerformed(evt);
            }
        });

        btnFuncionarioRegistrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnFuncionarioRegistrar.setText("Registrar");
        btnFuncionarioRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioRegistrarActionPerformed(evt);
            }
        });

        fFuncionarioNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioNascimentoActionPerformed(evt);
            }
        });

        lblFuncionarioNascimento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioNascimento.setText("Data de nascimento:");

        lblFuncionarioEndereco.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioEndereco.setText("Endereço:");

        fFuncionarioEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioEnderecoActionPerformed(evt);
            }
        });

        fFuncionarioTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioTelefoneActionPerformed(evt);
            }
        });

        lblFuncionarioSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioSenha.setText("Senha:");

        fFuncionarioSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioSenhaActionPerformed(evt);
            }
        });

        lblFuncionarioUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioUsuario.setText("Usuário:");

        fFuncionarioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioUsuarioActionPerformed(evt);
            }
        });

        lblFuncionarioCPF.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioCPF.setText("CPF:");

        fFuncionarioCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioCPFActionPerformed(evt);
            }
        });

        lblFuncionarioCidade.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioCidade.setText("Cidade:");

        fFuncionarioCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioCidadeActionPerformed(evt);
            }
        });

        lblFuncionarioTelefone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioTelefone.setText("Telefone");

        fFuncionarioEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFuncionarioEmailActionPerformed(evt);
            }
        });

        lblFuncionarioEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionarioEmail.setText("E-mail:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncionarioNome)
                            .addComponent(lblFuncionarioSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fFuncionarioSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(fFuncionarioNome))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionarioSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fFuncionarioSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionarioUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fFuncionarioUsuario))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblFuncionarioEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fFuncionarioEndereco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionarioNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fFuncionarioNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionarioTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fFuncionarioTelefone)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFuncionarioCPF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fFuncionarioCPF))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFuncionarioCidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fFuncionarioCidade))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFuncionarioEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fFuncionarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLoginFuncionario)
                        .addGap(286, 286, 286))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFuncionarioRegistrar)
                        .addGap(349, 349, 349))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblLoginFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuncionarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuncionarioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuncionarioCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuncionarioCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFuncionarioCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFuncionarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fFuncionarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFuncionarioTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fFuncionarioTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnFuncionarioRegistrar)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fFuncionarioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioNomeActionPerformed

    private void fFuncionarioSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioSexoActionPerformed

    private void btnFuncionarioRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFuncionarioRegistrarActionPerformed

    private void fFuncionarioNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioNascimentoActionPerformed

    private void fFuncionarioEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioEnderecoActionPerformed

    private void fFuncionarioTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioTelefoneActionPerformed

    private void fFuncionarioSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioSenhaActionPerformed

    private void fFuncionarioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioUsuarioActionPerformed

    private void fFuncionarioCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioCPFActionPerformed

    private void fFuncionarioCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioCidadeActionPerformed

    private void fFuncionarioEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFuncionarioEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFuncionarioEmailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrFuncionarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrFuncionarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrFuncionarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrFuncionarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrFuncionarioCadastro dialog = new FrFuncionarioCadastro(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFuncionarioRegistrar;
    private javax.swing.JFormattedTextField fFuncionarioCPF;
    private javax.swing.JFormattedTextField fFuncionarioCidade;
    private javax.swing.JFormattedTextField fFuncionarioEmail;
    private javax.swing.JFormattedTextField fFuncionarioEndereco;
    private javax.swing.JFormattedTextField fFuncionarioNascimento;
    private javax.swing.JFormattedTextField fFuncionarioNome;
    private javax.swing.JFormattedTextField fFuncionarioSenha;
    private javax.swing.JFormattedTextField fFuncionarioSexo;
    private javax.swing.JFormattedTextField fFuncionarioTelefone;
    private javax.swing.JFormattedTextField fFuncionarioUsuario;
    private javax.swing.JLabel lblFuncionarioCPF;
    private javax.swing.JLabel lblFuncionarioCidade;
    private javax.swing.JLabel lblFuncionarioEmail;
    private javax.swing.JLabel lblFuncionarioEndereco;
    private javax.swing.JLabel lblFuncionarioNascimento;
    private javax.swing.JLabel lblFuncionarioNome;
    private javax.swing.JLabel lblFuncionarioSenha;
    private javax.swing.JLabel lblFuncionarioSexo;
    private javax.swing.JLabel lblFuncionarioTelefone;
    private javax.swing.JLabel lblFuncionarioUsuario;
    private javax.swing.JLabel lblLoginFuncionario;
    // End of variables declaration//GEN-END:variables
}

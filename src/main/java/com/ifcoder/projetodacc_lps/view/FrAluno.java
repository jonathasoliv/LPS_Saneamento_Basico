/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_lps.view;

import com.ifcoder.projetodacc_lps.controller.AlunoController;
import com.ifcoder.projetodacc_lps.model.Aluno;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import com.ifcoder.projetodacc_lps.model.exceptions.AlunoException;
import com.ifcoder.projetodacc_lps.model.exceptions.ProfessorException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joserui
 */
public class FrAluno extends javax.swing.JDialog {

    AlunoController alunoController;
    int idAlunoEditando;

    public FrAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        alunoController = new AlunoController();
        idAlunoEditando = -1;

        initComponents();
        this.adicionarMascaraNosCampos();

        this.habilitarCampos(false);
        this.limparCampos();

        //edtListagem.setText(profController.imprimirListaProfessores());
        alunoController.atualizarTabela(grdAlunos);
    }

    public void habilitarCampos(boolean flag) {
        for (int i = 0; i < panFormulario.getComponents().length; i++) {
            panFormulario.getComponent(i).setEnabled(flag);
        }
    }

    public void limparCampos() {
        edtNome.setText("");
        edtSexo.setText("");
        edtIdade.setText("");
        fEdtMatricula.setText("");
    }

    public void adicionarMascaraNosCampos() {
        try {
            MaskFormatter maskMatricula = new MaskFormatter("####-##");
            maskMatricula.install(fEdtMatricula);   
            
            MaskFormatter maskAno = new MaskFormatter("####");
            maskAno.install(fEdtAno);
        } catch (ParseException ex) {
            Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
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
    public void preencherFormulario(Aluno a) {
        edtNome.setText(a.getNome());
        edtSexo.setText(a.getSexo() + "");
        edtIdade.setText(a.getIdade() + "");
        fEdtMatricula.setText(a.getMatricula());
        fEdtAno.setText(a.getAnoIngresso() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        panBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        panFormulario = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        edtIdade = new javax.swing.JTextField();
        lblNome2 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        edtSexo = new javax.swing.JTextField();
        lblSexo1 = new javax.swing.JLabel();
        fEdtAno = new javax.swing.JFormattedTextField();
        fEdtMatricula = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usando JDBC SQLite");

        lblTitle.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Cadastro de Aluno");

        btnNovo.setForeground(new java.awt.Color(0, 25, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo_32x32.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        panBotoes.add(btnNovo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit3_32x32.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panBotoes.add(btnEditar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel_32x32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panBotoes.add(btnCancelar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/del_32x32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        panBotoes.add(btnExcluir);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_32x32.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        panBotoes.add(btnSalvar);

        lblNome.setText("Nome:");

        lblNome1.setText("Idade:");

        lblNome2.setText("Matricula:");

        lblSexo.setText("Sexo:");

        lblSexo1.setText("Ano:");

        fEdtAno.setText("jFormattedTextField1");

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(lblSexo))
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fEdtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSexo1)))
                .addGap(18, 18, 18)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fEdtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        panFormularioLayout.setVerticalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome1)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome2)
                    .addComponent(lblSexo1)
                    .addComponent(fEdtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fEdtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        grdAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdAlunos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (idAlunoEditando > 0) {
                alunoController.atualizarAluno(idAlunoEditando, edtNome.getText(), edtSexo.getText(), edtIdade.getText(), fEdtMatricula.getText(), fEdtAno.getText());
            } else {
                alunoController.cadastrarAluno(edtNome.getText(), edtSexo.getText(), edtIdade.getText(), fEdtMatricula.getText(), fEdtAno.getText());
            }
            //Comando bastante importante
            this.idAlunoEditando = -1;

            alunoController.atualizarTabela(grdAlunos);

            this.habilitarCampos(false);
            this.limparCampos();
        } catch (AlunoException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.idAlunoEditando = -1;

        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Aluno alunoExcluido = (Aluno) this.getObjetoSelecionadoNaGrid();

        if (alunoExcluido == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                    "Deseja exlcuir o Aluno  \n("
                    + alunoExcluido.getNome() + ", "
                    + alunoExcluido.getMatricula() + ") ?",
                    "Confirmar exclusão",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    alunoController.excluirAluno(alunoExcluido);

                    alunoController.atualizarTabela(grdAlunos);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (ProfessorException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Aluno alunoEditando = (Aluno) this.getObjetoSelecionadoNaGrid();

        if (alunoEditando == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            this.limparCampos();
            this.habilitarCampos(true);
            this.preencherFormulario(alunoEditando);
            this.idAlunoEditando = alunoEditando.getId();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * Retorna o objeto (classe) da linha selecionada na grid.
     *
     * Uso a estratégia do metodo getValueAt() la na TableModel, receber coluna
     * -1 e retornar o objeto ao inves de uma célula.
     *
     * @return
     */
    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdAlunos.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdAlunos.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private void grdAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdAlunosMouseClicked
        if (evt.getClickCount() == 2) {
            btnEditarActionPerformed(null);
        }
    }//GEN-LAST:event_grdAlunosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JFormattedTextField fEdtAno;
    private javax.swing.JFormattedTextField fEdtMatricula;
    private javax.swing.JTable grdAlunos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNome2;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexo1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panFormulario;
    // End of variables declaration//GEN-END:variables
}

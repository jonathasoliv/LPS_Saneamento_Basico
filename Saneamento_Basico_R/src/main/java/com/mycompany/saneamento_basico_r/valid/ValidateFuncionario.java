/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Funcionario;
import com.mycompany.saneamento_basico_r.model.entities.Usuario;
import com.mycompany.saneamento_basico_r.model.exceptions.FuncionarioException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateFuncionario extends ValidateUsuario {

    public Funcionario validaCamposEntrada(String cpf, String nome, String email, String senha, String senhaConfirmada,
            String dataNascimento,
            String telefone, String endereco, String deletadoEm, String dataContratacao) {

        Funcionario funcionario = new Funcionario();
        Usuario base = super.validaCamposEntrada(cpf, nome, email, senha, senhaConfirmada, dataNascimento, telefone, endereco, deletadoEm);
        funcionario.setCpf(base.getCpf());
        funcionario.setNome(base.getNome());
        funcionario.setEmail(base.getEmail());
        funcionario.setSenha(base.getSenha());
        funcionario.setDataNascimento(base.getDataNascimento());
        funcionario.setTelefone(base.getTelefone());
        funcionario.setEndereco(base.getEndereco());
        funcionario.setDeletadoEm(base.getDeletadoEm());

        if (dataContratacao == null || dataContratacao.isEmpty())
            throw new FuncionarioException("ERRO: Campo data de contratação não pode ser vazio.");
        LocalDate dataConvertida;
        try {
            dataConvertida = LocalDate.parse(dataContratacao);
            if (dataConvertida.isAfter(LocalDate.now())) {
                throw new FuncionarioException("ERRO: Data de contratação não pode ser no futuro.");
            }
        } catch (DateTimeParseException e) {
            throw new FuncionarioException("ERRO: Formato de data inválido.");
        }
        funcionario.setDataContratacao(dataConvertida);

        return funcionario;

    }

}
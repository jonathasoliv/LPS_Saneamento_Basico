/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Gerente;
import com.mycompany.saneamento_basico_r.model.entities.Usuario;
import com.mycompany.saneamento_basico_r.model.exceptions.GerenteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateGerente extends ValidateUsuario {

    public Gerente validaCamposEntrada(String cpf, String nome, String email, String senha, String senhaConfirmada,
            String dataNascimento,
            String telefone, String endereco, String deletadoEm, String dataContratacao) {

        Gerente gerente = new Gerente();
        Usuario base = super.validaCamposEntrada(cpf, nome, email, senha, senhaConfirmada, dataNascimento, telefone, endereco, deletadoEm);

        gerente.setCpf(base.getCpf());
        gerente.setNome(base.getNome());
        gerente.setEmail(base.getEmail());
        gerente.setSenha(base.getSenha());
        gerente.setDataNascimento(base.getDataNascimento());
        gerente.setTelefone(base.getTelefone());
        gerente.setEndereco(base.getEndereco());
        gerente.setDeletadoEm(base.getDeletadoEm());

        if (dataContratacao == null || dataContratacao.isEmpty())
            throw new GerenteException("ERRO: Campo data de contratação não pode ser vazio.");
        LocalDate dataConvertida;
        try {
            dataConvertida = LocalDate.parse(dataContratacao);
            if (dataConvertida.isAfter(LocalDate.now())) {
                throw new GerenteException("ERRO: Data de contratação não pode ser no futuro.");
            }
        } catch (DateTimeParseException e) {
            throw new GerenteException("ERRO: Formato de data inválido.");
        }
        gerente.setDataContratacao(dataConvertida);

        return gerente;

    }

}
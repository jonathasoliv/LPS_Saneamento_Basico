/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Funcionario;
import com.mycompany.saneamento_basico_r.model.exceptions.FuncionarioException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author JonathasOliveira
 */

import com.mycompany.saneamento_basico_r.model.entities.Pessoa;
import com.mycompany.saneamento_basico_r.model.exceptions.FuncionarioException;

public class ValidateFuncionario extends ValidatePessoa {

    public Funcionario validaCamposEntrada(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro) {

        Funcionario funcionario = new Funcionario();
        Pessoa base = super.validaCamposEntrada(nome, sexo, idade, cpf,
                endereco, email, senha, telefone, cidade, bairro);
        
        funcionario.setNome(base.getNome());
        funcionario.setSexo(base.getSexo());
        funcionario.setIdade(base.getIdade());
        funcionario.setCpf(base.getCpf());
        funcionario.setEndereco(base.getEndereco());
        funcionario.setEmail(base.getEmail());
        funcionario.setSenha(base.getSenha());
        funcionario.setTelefone(base.getTelefone());
        funcionario.setCidade(base.getCidade());
        funcionario.setBairro(base.getBairro());


        return funcionario;

    }

}
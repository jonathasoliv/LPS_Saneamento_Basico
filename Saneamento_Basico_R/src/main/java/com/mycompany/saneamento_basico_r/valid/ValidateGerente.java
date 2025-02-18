/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Gerente;
import com.mycompany.saneamento_basico_r.model.exceptions.GerenteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author JonathasOliveira
 */
import com.mycompany.saneamento_basico_r.model.entities.Gerente;
import com.mycompany.saneamento_basico_r.model.entities.Pessoa;

public class ValidateGerente extends ValidatePessoa {

    public Gerente validaCamposEntrada(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro) {

        Gerente gerente = new Gerente();
        Pessoa base = super.validaCamposEntrada(nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro);
        
        gerente.setNome(base.getNome());
        gerente.setSexo(base.getSexo());
        gerente.setIdade(base.getIdade());
        gerente.setCpf(base.getCpf());
        gerente.setEndereco(base.getEndereco());
        gerente.setEmail(base.getEmail());
        gerente.setSenha(base.getSenha());
        gerente.setTelefone(base.getTelefone());
        gerente.setCidade(base.getCidade());
        gerente.setBairro(base.getBairro());
       

        return gerente;

    }

}
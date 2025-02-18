/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import com.mycompany.saneamento_basico_r.model.entities.Pessoa;
import com.mycompany.saneamento_basico_r.model.exceptions.AdministradorException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author JonathasOliveira
 */
public class ValidateAdmin extends ValidatePessoa {

    public Administrador validaCamposEntrada(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro) {

        Administrador admin = new Administrador();

        Pessoa base = super.validaCamposEntrada(nome, sexo, idade, cpf, endereco, 
                email, senha, telefone, cidade, bairro);
        
        admin.setNome(base.getNome());
        admin.setSexo(base.getSexo());
        admin.setIdade(base.getIdade());
        admin.setCpf(base.getCpf());
        admin.setEndereco(base.getEndereco());
        admin.setEmail(base.getEmail());
        admin.setSenha(base.getSenha());
        admin.setTelefone(base.getTelefone());
        admin.setCidade(base.getCidade());
        admin.setBairro(base.getBairro());
        

        return admin;

    }

}
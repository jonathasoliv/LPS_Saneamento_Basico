/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import com.mycompany.saneamento_basico_r.model.exceptions.AdministradorException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author JonathasOliveira
 */
public class ValidateAdministrador {
     public Administrador validaCamposEntrada(String nome, String sexo, int idade, String cpf, String dataNascimento, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora){
        
        Administrador administrador = new Administrador();
        
        if (nome.isEmpty())
            throw new AdministradorException("Error - Campo vazio: 'nome'.");
        administrador.setNome(nome);
        
        String sexoUpperCase = sexo.toUpperCase();

        if (!sexoUpperCase.equals("M") && !sexoUpperCase.equals("F")) {
            throw new AdministradorException("Erro - Valor inválido no campo 'sexo'.");
        }
        administrador.setSexo(sexoUpperCase);

        if (idade < 0)
            throw new AdministradorException("Error - Valor inválido no campo 'idade'.");
        administrador.setIdade(idade); 
        
        /*if (cpf.isEmpty() || validaCPF(cpf)) {
            throw new AdministradorException("Error - CPF inválido no campo 'cpf'.");
        }
        administrador.setCpf(cpf);
        */
        
        if (dataNascimento.isEmpty()) {
        throw new AdministradorException("Error - Campo vazio: 'dataNascimento'.");
        }
        try {
            LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy")); //dia, mes, ano
        } catch (DateTimeParseException e) {
            throw new AdministradorException("Error - Data de nascimento inválida no campo 'dataNascimento'.");
        }
        
        if (endereco.isEmpty()) {
            throw new AdministradorException("Error - Campo vazio: 'endereco'.");
        }
        if (endereco.length() > 500) {
            throw new AdministradorException("Error - Endereço muito longo no campo 'endereco'.");
        }
        
        if (email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,4}$")) {
            throw new AdministradorException("Error - Email inválido no campo 'email'.");
        }
        
        if (senha.isEmpty() || senha.length() < 8) { //senha com 8 caracteres
            throw new AdministradorException("Error - Senha inválida no campo 'senha'.");
        }
        
        if (telefone.isEmpty() || !telefone.matches("\\d{10,11}")) {
            throw new AdministradorException("Error - Telefone inválido no campo 'telefone'.");
        }
        
        if (cidade.isEmpty()) {
            throw new AdministradorException("Error - Campo vazio: 'cidade'.");
        }
        if (cidade.length() > 100) { // Limite de comprimento máximo (altere conforme necessário)
            throw new AdministradorException("Error - Nome de cidade muito longa no campo 'cidade'.");
        }

        if (bairro.isEmpty()) {
            throw new AdministradorException("Error - Campo vazio: 'bairro'.");
        }
        if (bairro.length() > 100) { // Limite de comprimento máximo (altere conforme necessário)
            throw new AdministradorException("Error - Bairro muito longo no campo 'bairro'.");
        }

        return administrador;
    }

}

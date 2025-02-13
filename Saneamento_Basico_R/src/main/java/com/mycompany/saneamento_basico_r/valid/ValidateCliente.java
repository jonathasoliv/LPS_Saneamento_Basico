/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Cliente;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author JonathasOliveira
 */
public class ValidateCliente {
    
    public Cliente validaCamposEntrada(String nome, String sexo, String idade, String cpf, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora){
        
        Cliente cliente = new Cliente();
        
        if (nome.isEmpty())
            throw new ClienteException("Error - Campo vazio: 'nome'.");
        cliente.setNome(nome);
        
        String sexoUpperCase = sexo.toUpperCase();

        if (!sexoUpperCase.equals("M") && !sexoUpperCase.equals("F")) {
            throw new ClienteException("Erro - Valor inválido no campo 'sexo'.");
        }
        cliente.setSexo(sexoUpperCase);

        /*if (idade < 0)
            throw new ClienteException("Error - Valor inválido no campo 'idade'.");
        cliente.setIdade(idade); */
        
        /*if (cpf.isEmpty() || validaCPF(cpf)) {
            throw new ClienteException("Error - CPF inválido no campo 'cpf'.");
        }
        cliente.setCpf(cpf);
        */
        
        /*if (dataNascimento.isEmpty()) {
        throw new ClienteException("Error - Campo vazio: 'dataNascimento'.");
        }
        try {
            LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy")); //dia, mes, ano
        } catch (DateTimeParseException e) {
            throw new ClienteException("Error - Data de nascimento inválida no campo 'dataNascimento'.");
        }*/
        
        if (endereco.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'endereco'.");
        }
        if (endereco.length() > 500) {
            throw new ClienteException("Error - Endereço muito longo no campo 'endereco'.");
        }
        
        if (email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,4}$")) {
            throw new ClienteException("Error - Email inválido no campo 'email'.");
        }
        
        if (senha.isEmpty() || senha.length() < 8) { //senha com 8 caracteres
            throw new ClienteException("Error - Senha inválida no campo 'senha'.");
        }
        
        if (telefone.isEmpty() || !telefone.matches("\\d{10,11}")) {
            throw new ClienteException("Error - Telefone inválido no campo 'telefone'.");
        }
        
        if (cidade.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'cidade'.");
        }
        if (cidade.length() > 100) { // Limite de comprimento máximo (altere conforme necessário)
            throw new ClienteException("Error - Nome de cidade muito longa no campo 'cidade'.");
        }

        if (bairro.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'bairro'.");
        }
        if (bairro.length() > 100) { // Limite de comprimento máximo (altere conforme necessário)
            throw new ClienteException("Error - Bairro muito longo no campo 'bairro'.");
        }

        return cliente;
    }

    
}


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
public class ValidateFuncionario {
    public Funcionario validaCamposEntrada(String nome, String sexo, String idade, String cpf, String dataNascimento, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora){
        
        Funcionario funcionario = new Funcionario();
        
        if (nome.isEmpty())
            throw new FuncionarioException("Error - Campo vazio: 'nome'.");
        funcionario.setNome(nome);
        
        String sexoUpperCase = sexo.toUpperCase();

        if (!sexoUpperCase.equals("M") && !sexoUpperCase.equals("F")) {
            throw new FuncionarioException("Erro - Valor inválido no campo 'sexo'.");
        }
        funcionario.setSexo(sexoUpperCase);

        /*if (idade < 0)
            throw new FuncionarioException("Error - Valor inválido no campo 'idade'.");
        funcionario.setIdade(idade); */
        
        /*if (cpf.isEmpty() || validaCPF(cpf)) {
            throw new FuncionarioException("Error - CPF inválido no campo 'cpf'.");
        }
        funcionario.setCpf(cpf);
        */
        
        if (dataNascimento.isEmpty()) {
        throw new FuncionarioException("Error - Campo vazio: 'dataNascimento'.");
        }
        try {
            LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy")); //dia, mes, ano
        } catch (DateTimeParseException e) {
            throw new FuncionarioException("Error - Data de nascimento inválida no campo 'dataNascimento'.");
        }
        
        if (endereco.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'endereco'.");
        }
        if (endereco.length() > 500) {
            throw new FuncionarioException("Error - Endereço muito longo no campo 'endereco'.");
        }
        
        if (email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,4}$")) {
            throw new FuncionarioException("Error - Email inválido no campo 'email'.");
        }
        
        if (senha.isEmpty() || senha.length() < 8) { //senha com 8 caracteres
            throw new FuncionarioException("Error - Senha inválida no campo 'senha'.");
        }
        
        if (telefone.isEmpty() || !telefone.matches("\\d{10,11}")) {
            throw new FuncionarioException("Error - Telefone inválido no campo 'telefone'.");
        }
        
        if (cidade.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'cidade'.");
        }
        if (cidade.length() > 100) { // Limite de comprimento máximo (altere conforme necessário)
            throw new FuncionarioException("Error - Nome de cidade muito longa no campo 'cidade'.");
        }

        if (bairro.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'bairro'.");
        }
        if (bairro.length() > 100) { // Limite de comprimento máximo (altere conforme necessário)
            throw new FuncionarioException("Error - Bairro muito longo no campo 'bairro'.");
        }

        return funcionario;
    }

}

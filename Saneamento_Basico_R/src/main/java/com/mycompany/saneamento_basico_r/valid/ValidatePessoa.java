/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Pessoa;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import com.mycompany.saneamento_basico_r.model.exceptions.PessoaException;

public class ValidatePessoa {

    private boolean isCpfValido(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.length() == 11 && cpf.matches("[0-9]*")) {
            String[] vet = cpf.split("");

            int digito1 = Integer.parseInt(vet[9]);
            int digito2 = Integer.parseInt(vet[10]);

            int soma1 = 0;
            int fator1 = 10;
            for (int i = 0; i <= 8; i++) {
                int val = Integer.parseInt(vet[i]);
                soma1 = soma1 + (fator1 * val);
                fator1--;
            }

            int resultado1 = (soma1 * 10) % 11;
            if (resultado1 == 10)
                resultado1 = 0;

            if (resultado1 != digito1) {
                return false;
            }

            int soma2 = 0;
            int fator2 = 11;
            for (int i = 0; i <= 9; i++) {
                int val = Integer.parseInt(vet[i]);
                soma2 = soma2 + (fator2 * val);
                fator2--;
            }

            int resultado2 = (soma2 * 10) % 11;
            if (resultado2 == 10)
                resultado2 = 0;

            if (resultado2 != digito2) {
                return false;
            }

            for (int i = 0; i <= 9; i++) {
                int val = Integer.parseInt(vet[i]);
                int valProx = Integer.parseInt(vet[i + 1]);
                if (val != valProx)
                    return true;
            }
        }

        return false;
    }

    public String validaSenha(String senha) {
        if (senha == null || senha.isEmpty())
            throw new PessoaException("ERRO: Campo senha não pode ser vazio.");
        if (senha.length() < 6)
            throw new PessoaException("ERRO: Senha deve ter pelo menos 6 caracteres.");
        return senha;
    }

    public void validaExclusão(Pessoa usuario, int idUsuarioAutenticado) {
        if (usuario.getId() == idUsuarioAutenticado) {
            throw new PessoaException("ERRO: Você não pode deletar a si mesmo.");
        }
    }

    public Pessoa validaCamposEntrada(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro,
            String unidadeConsumidora) {

        Pessoa cliente = new Pessoa();

        if (nome.isEmpty())
            throw new ClienteException("Error - Campo vazio: 'nome'.");
        cliente.setNome(nome);
        
        String sexoUpperCase = sexo.toUpperCase();

        if (!sexoUpperCase.equals("M") && !sexoUpperCase.equals("F")) {
            throw new ClienteException("Erro - Valor inválido no campo 'sexo'.");
        }
        cliente.setSexo(sexoUpperCase);

        if (idade.isEmpty()){
            throw new ClienteException("Error - Valor inválido no campo 'idade'.");
        }
        cliente.setIdade(idade);
        
        if (cpf == null || cpf.isEmpty())
            throw new PessoaException("ERRO: Campo CPF não pode ser vazio.");
        if (!isCpfValido(cpf))
            throw new PessoaException("ERRO: CPF não é válido");
        cliente.setCpf(cpf);
        
        
        
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
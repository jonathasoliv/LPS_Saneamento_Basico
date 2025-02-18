/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Cliente;
import com.mycompany.saneamento_basico_r.model.entities.Pessoa;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;

public class ValidateCliente extends ValidatePessoa {

    public Cliente validaCamposEntrada(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro,
            String unidadeConsumidora) {

        Cliente cliente = new Cliente();
        
        Pessoa base = super.validaCamposEntrada(0, nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro, unidadeConsumidora);
        
        cliente.setNome(base.getNome());
        cliente.setSexo(base.getSexo());
        cliente.setIdade(base.getIdade());
        cliente.setCpf(base.getCpf());
        cliente.setEndereco(base.getEndereco());
        cliente.setEmail(base.getEmail());
        cliente.setSenha(base.getSenha());
        cliente.setTelefone(base.getTelefone());
        cliente.setCidade(base.getCidade());
        cliente.setBairro(base.getBairro());
        //cliente.setUnidadeConsumidora(base.getUnidadeConsumidora());


        return cliente;
    }

}
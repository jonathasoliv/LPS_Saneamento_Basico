/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Cliente;
import com.mycompany.saneamento_basico_r.model.entities.Usuario;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author JonathasOliveira
 */

public class ValidateCliente extends ValidateUsuario {

    public Cliente validaCamposEntrada(String cpf, String nome, String email, String senha, String senhaConfirmada,
            String dataNascimento,
            String telefone, String endereco, String deletadoEm,
            String historicoConsumo) {

        Cliente cliente = new Cliente();
        Usuario base = super.validaCamposEntrada(cpf, nome, email, senha, senhaConfirmada, dataNascimento, telefone, endereco, deletadoEm);
        cliente.setCpf(base.getCpf());
        cliente.setNome(base.getNome());
        cliente.setEmail(base.getEmail());
        cliente.setSenha(base.getSenha());
        cliente.setDataNascimento(base.getDataNascimento());
        cliente.setTelefone(base.getTelefone());
        cliente.setEndereco(base.getEndereco());
        cliente.setDeletadoEm(base.getDeletadoEm());

       

        return cliente;
    }

}


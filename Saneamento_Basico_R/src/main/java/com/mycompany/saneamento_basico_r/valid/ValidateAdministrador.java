/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.valid;

import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import com.mycompany.saneamento_basico_r.model.entities.Usuario;
import com.mycompany.saneamento_basico_r.model.exceptions.AdministradorException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author JonathasOliveira
 */

public class ValidateAdministrador extends ValidateUsuario {

    public Administrador validaCamposEntrada(String cpf, String nome, String email, String senha, String senhaConfirmada,
            String dataNascimento,
            String telefone, String endereco, String deletadoEm) {

        Administrador administrador = new Administrador();

        Usuario base = super.validaCamposEntrada(cpf, nome, email, senha, senhaConfirmada, dataNascimento, telefone,
                endereco,
                deletadoEm);
        administrador.setCpf(base.getCpf());
        administrador.setNome(base.getNome());
        administrador.setEmail(base.getEmail());
        administrador.setSenha(base.getSenha());
        administrador.setDataNascimento(base.getDataNascimento());
        administrador.setTelefone(base.getTelefone());
        administrador.setEndereco(base.getEndereco());
        administrador.setDeletadoEm(base.getDeletadoEm());

        return administrador;

    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author JonathasOliveira
 */
public class Administrador extends Usuario{

    public Administrador() {
        super();
    }
    
    public Administrador(String nome, String sexo, int idade, String cpf, String endereco,
            String email, String senha, String telefone, String cidade, String bairro, 
            String unidadeConsumidora, LocalDateTime deletadoEm) {
        super(0, nome, sexo, idade, cpf, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora, deletadoEm);
    }

}

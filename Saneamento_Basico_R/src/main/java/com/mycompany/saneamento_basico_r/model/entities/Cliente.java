/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CLIENTE")
@Setter
@Getter
@NoArgsConstructor
public class Cliente extends Usuario {
 
    private String historicoConsumo;

    public Cliente(String cpf, String nome, String email, String senha, LocalDate dataNascimento,
            String telefone, String endereco, LocalDateTime deletadoEm, String historicoConsumo) {
        super(0, cpf, nome, email, senha, dataNascimento, telefone, endereco, deletadoEm);
        this.historicoConsumo = historicoConsumo;
    }

}
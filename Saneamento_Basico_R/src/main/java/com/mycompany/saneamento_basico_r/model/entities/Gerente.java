/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;

import com.mycompany.saneamento_basico_r.model.entities.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author JonathasOliveira
 */
import com.mycompany.saneamento_basico_r.model.entities.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("GERENTE")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor

public class Gerente extends Usuario {

    private LocalDate dataContratacao;
    public Gerente(String nome, String sexo, int idade, String cpf, String endereco,
            String email, String senha, String telefone, String cidade, String bairro, 
            String unidadeConsumidora, LocalDateTime deletadoEm, String historicoConsumo) {
        super(0,nome, sexo, idade, cpf, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora, deletadoEm);
        
        this.dataContratacao = dataContratacao;
    }
    
}

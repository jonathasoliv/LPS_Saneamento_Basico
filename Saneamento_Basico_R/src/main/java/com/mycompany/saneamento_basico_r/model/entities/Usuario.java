/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;
    @NonNull protected String nome;
    @NonNull protected String sexo;
    @NonNull protected int idade;
    protected String cpf;
    protected String endereco;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String cidade;
    protected String bairro;
    protected String unidadeConsumidora;
    protected LocalDateTime deletadoEm;
}

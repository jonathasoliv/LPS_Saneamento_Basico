/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;

import com.mycompany.saneamento_basico_r.model.entities.Pessoa;

/**
 *
 * @author JonathasOliveira
 */
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("FUNCIONARIO")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Funcionario extends Pessoa {

    public Funcionario(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro)
    {
        super(0, nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro);
    }
}

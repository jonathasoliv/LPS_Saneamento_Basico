/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GERENTE")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Gerente extends Pessoa {

    public Gerente(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro)
    {
        super(0, nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro);
    }

}

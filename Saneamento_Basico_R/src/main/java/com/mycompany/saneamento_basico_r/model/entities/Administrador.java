package com.mycompany.saneamento_basico_r.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Administrador extends Pessoa {

    public Administrador(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro)
    {
        super(0, nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro);
    }

}

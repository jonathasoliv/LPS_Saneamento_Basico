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
public class Cliente extends Pessoa{
    private int id;

    public Cliente() {
        super();
        
    }
    
    public Cliente(String id, String nome, String sexo, String idade,
            String cpf, String endereco, String email, String senha,
            String telefone, String cidade, String bairro,
            String unidadeConsumidora)
    {
        super(nome, sexo, idade, cpf, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora);
        this.id = Integer.parseInt(id);
        
    }
    
    public void copiar(Cliente outro) {
        this.setId(outro.getId());
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
        this.cpf = outro.getCpf();
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model;

/**
 *
 * @author JonathasOliveira
 */
public class Funcionario extends Pessoa{
    private int id;

    public Funcionario() {
        super();
        
    }
    
    public Funcionario(int id, String nome, String sexo, int idade, String cpf, String dataNascimento, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora) {
        super(nome, sexo, idade, cpf, dataNascimento, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora);
        this.id = id;
        
    }
    
    public void copiar(Funcionario outro) {
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

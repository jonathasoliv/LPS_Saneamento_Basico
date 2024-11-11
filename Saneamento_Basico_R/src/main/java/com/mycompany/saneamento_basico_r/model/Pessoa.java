/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model;

/**
 *
 * @author JonathasOliveira
 */
import java.util.Scanner;

public class Pessoa {
    
    String nome;
    String sexo;
    int idade;
    String cpf;
    private String dataNascimento;
    private String endereco;
    private String email;
    private String senha;
    private String telefone;
    private String cidade;
    private String bairro;
    private String unidadeConsumidora;

    public Pessoa() {
        this.nome = " ";
        this.sexo = " ";
        this.idade = 0;
        this.cpf = "###.###.###-##";
        this.dataNascimento = "00-00-0000";
        this.endereco = " ";
        this.email = " ";
        this.senha = " ";
        this.telefone = " ";
        this.cidade = " ";
        this.bairro = " ";
        this.unidadeConsumidora = " ";
    }

    public Pessoa(String nome, String sexo, int idade, String cpf, String dataNascimento, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora) {
        this.nome = " ";
        this.sexo = " ";
        this.idade = 0;
        this.cpf = "###.###.###-##";
        this.dataNascimento = "00-00-0000";  /*dia - mes - ano*/
        this.endereco = " ";
        this.email = " ";
        this.senha = " ";
        this.telefone = " ";
        this.cidade = " ";
        this.bairro = " ";
        this.unidadeConsumidora = " ";
    } 

    @Override
    public String toString() {
        String txt = "Nome: " + this.getNome() +"\n"
        +"Sexo: "+ this.getSexo() + "\n"
        +"Idade: "+ this.getIdade()+"\n"
        +"Cpf: "+ this.getCpf()+"\n"
        +"Data de Nascimento: "+ this.getDataNascimento()+"\n"
        +"Endereco: "+ this.getEndereco()+"\n"
        +"Email: "+ this.getEmail()+"\n"
        +"Senha: "+ this.getSenha()+"\n"
        +"Telefone: "+ this.getTelefone()+"\n"
        +"Cidade: "+ this.getCidade()+"\n"
        +"Bairro: "+ this.getBairro()+"\n"
        +"Unidade Consumidora: "+ this.getUnidadeConsumidora()+"\n";
        
        return txt;
    }   
    
    @Override
    public boolean equals(Object obj) {
        Pessoa outro = (Pessoa) obj;
        if(!this.nome.equals(outro.getNome()))
            return false;
        else if(this.getIdade() != outro.getIdade())
            return false;
        else if(this.getCpf() != outro.getCpf())
            return false;
        else if(this.getSexo() != outro.getSexo())
            return false;
        else if(this.getDataNascimento() != outro.getDataNascimento())
            return false;
        else if(this.getEndereco() != outro.getEndereco())
            return false;
        else if(this.getEmail() != outro.getEmail())
            return false;
        else if(this.getSenha() != outro.getSenha())
            return false;
        else if(this.getTelefone() != outro.getTelefone())
            return false;
        else if(this.getCidade()  != outro.getCidade())
            return false;
        else if(this.getBairro()  != outro.getBairro())
            return false;
        else if(this.getUnidadeConsumidora()  != outro.getUnidadeConsumidora())
            return false;
        
        return true;
    }
    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getSexo() {
        return sexo;
    }

    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
    public int getIdade() {
        return idade;
    }

    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the unidadeConsumidora
     */
    public String getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    /**
     * @param unidadeConsumidora the unidadeConsumidora to set
     */
    public void setUnidadeConsumidora(String unidadeConsumidora) {
        this.unidadeConsumidora = unidadeConsumidora;
    }

    
           
}

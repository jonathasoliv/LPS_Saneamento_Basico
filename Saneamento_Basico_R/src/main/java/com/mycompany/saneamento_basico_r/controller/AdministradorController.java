/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.model.dao.AdministradorDAO;
import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import com.mycompany.saneamento_basico_r.model.exceptions.AdministradorException;
import com.mycompany.saneamento_basico_r.valid.ValidateAdministrador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author JonathasOliveira
 */
public class AdministradorController {
   private AdministradorDAO repositorio;
   
   public AdministradorController() {
        repositorio = new AdministradorDAO();
    }

    public void cadastrarAdministrador(String nome, String sexo, int idade, String cpf, String dataNascimento, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora) {
        ValidateAdministrador valid = new ValidateAdministrador();
        
        Administrador novoAdministrador = valid.validaCamposEntrada(nome, sexo, idade, cpf, dataNascimento, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora);

        if (repositorio.findByEndereco(endereco) == null) {
            repositorio.save(novoAdministrador);
        } else {
            throw new AdministradorException("Error - Já existe um administrador com neste 'endereco'.");
        }
    }
    
    
    public void atualizarAdministrador(int idAdministrador, String nome, String sexo, int idade, String cpf, String dataNascimento, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora) {
        ValidateAdministrador valid = new ValidateAdministrador();
        Administrador novoAdministrador = valid.validaCamposEntrada(nome, sexo, idade, cpf, dataNascimento, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora);
        novoAdministrador.setId(idAdministrador);
        
        repositorio.update(novoAdministrador);
    }

    public Administrador buscarAdministrador(String endereco) {
        return (Administrador) this.repositorio.findByEndereco(endereco);
    }

    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();
        
        List<Administrador> lstAdministrador = new ArrayList<>();
        for(Object obj : lst){
            if(obj instanceof Administrador){
                lstAdministrador.add((Administrador)obj);
            }
        }
        //TMCadAdministrador tmAdministrador = new TMCadAdministrador(lstAdministrador); CONFERIR SE VAI FUNCIONAR NO SEU PC
        //grd.setModel(tmAdministrador);        
    }
    

    public void excluirAdministrador(Administrador administrador) {
        if (administrador != null) {
            repositorio.delete(administrador);
        } else {
            throw new AdministradorException("Error - Administrador inexistente.");
        }
    }    

}


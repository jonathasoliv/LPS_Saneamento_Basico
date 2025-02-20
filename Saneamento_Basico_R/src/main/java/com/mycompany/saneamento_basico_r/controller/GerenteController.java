/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.controller.tableModel.TMCadGerente;
import com.mycompany.saneamento_basico_r.model.dao.GerenteDAO;
import com.mycompany.saneamento_basico_r.model.entities.Gerente;
import com.mycompany.saneamento_basico_r.model.exceptions.GerenteException;
import com.mycompany.saneamento_basico_r.valid.ValidateGerente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author JonathasOliveira
 */

public class GerenteController {
    private GerenteDAO repositorio;

    public GerenteController() {
        repositorio = new GerenteDAO();
    }

    public void cadastrarGerente(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro) {
        
        ValidateGerente valid = new ValidateGerente();
        Gerente novoGerente = valid.validaCamposEntrada(nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro);

        if (repositorio.buscarPorCpf(cpf) == null) {
            repositorio.salvar(novoGerente);
        } else {
            throw new GerenteException("Error - Já existe um gerente com neste 'endereco'.");
        }
    }

    public void atualizarGerente(int idGerente, String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro) {
        
        ValidateGerente valid = new ValidateGerente();
        Gerente novoGerente = valid.validaCamposEntrada(nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro);
        novoGerente.setId(idGerente);
        
        repositorio.editar(novoGerente);
    }

    public Gerente buscarGerente(String endereco) {
        return (Gerente) this.repositorio.buscarPorCpf(endereco);
    }

    public void atualizarTabela(JTable grd) {
        List<Gerente> lst = repositorio.buscarTodos();
        
        List<Gerente> lstGerente = new ArrayList<>();
        for(Object obj : lst){
            if(obj instanceof Gerente){
                lstGerente.add((Gerente)obj);
            }
        }
        //TMCadGerente tmGerente = new TMCadGerente(lstGerente); //CONFERIR SE VAI FUNCIONAR NO SEU PC
        //grd.setModel(tmGerente);        
    }
    

    public void excluirGerente(Gerente gerente) {
        if (gerente != null) {
            repositorio.deletar(gerente);
        } else {
            throw new GerenteException("Error - gerente inexistente.");
        }
    }    

}

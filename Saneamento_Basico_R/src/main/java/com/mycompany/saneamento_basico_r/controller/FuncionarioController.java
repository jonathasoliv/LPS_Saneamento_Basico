/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.model.dao.FuncionarioDAO;
import com.mycompany.saneamento_basico_r.model.entities.Funcionario;
import com.mycompany.saneamento_basico_r.model.exceptions.FuncionarioException;
import com.mycompany.saneamento_basico_r.valid.ValidateFuncionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author JonathasOliveira
 */

public class FuncionarioController {
    private FuncionarioDAO repositorio;

    public FuncionarioController() {
        repositorio = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro) {
        ValidateFuncionario valid = new ValidateFuncionario();
        Funcionario novoFuncionario = valid.validaCamposEntrada(nome, sexo, idade, cpf, endereco, email, senha, telefone,
                cidade, bairro);

        if (repositorio.findByEndereco(endereco) == null) {
            repositorio.save(novoFuncionario);
        } else {
            throw new FuncionarioException("Error - Já existe um funcionario com neste 'endereco'.");
        }
    }

    public void atualizarFuncionario(String idFuncionario, String nome,
            String sexo, String idade, String cpf, String dataNascimento,
            String endereco, String email, String senha, String telefone,
            String cidade, String bairro, String unidadeConsumidora)
    {
        ValidateFuncionario valid = new ValidateFuncionario();
        
        Funcionario novoFuncionario = valid.validaCamposEntrada(nome, sexo,
                idade, cpf, dataNascimento, endereco, email, senha, telefone,
                cidade, bairro, unidadeConsumidora);
        
        novoFuncionario.setId(Integer.parseInt(idFuncionario));
        
        repositorio.update(novoFuncionario);
    }

    public Funcionario buscarFuncionario(String endereco) {
        return (Funcionario) this.repositorio.findByEndereco(endereco);
    }

    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();
        
        List<Funcionario> lstFuncionario = new ArrayList<>();
        for(Object obj : lst){
            if(obj instanceof Funcionario){
                lstFuncionario.add((Funcionario)obj);
            }
        }
        //TMCadFuncionario tmFuncionario = new TMCadFuncionario(lstFuncionario); CONFERIR SE VAI FUNCIONAR NO SEU PC
        //grd.setModel(tmFuncionario);        
    }
    

    public void excluirFuncionario(Funcionario funcionario) {
        if (funcionario != null) {
            repositorio.delete(funcionario);
        } else {
            throw new FuncionarioException("Error - Funcionario inexistente.");
        }
    }    

}

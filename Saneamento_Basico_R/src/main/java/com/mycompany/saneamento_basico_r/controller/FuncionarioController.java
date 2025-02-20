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

        if (repositorio.buscarPorCpf(endereco) == null) {
            repositorio.salvar(novoFuncionario);
        } else {
            throw new FuncionarioException("Error - Já existe um funcionario com neste 'endereco'.");
        }
    }

    public void atualizarFuncionario(String idFuncionario, String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro,
            String unidadeConsumidora)
    {
        ValidateFuncionario valid = new ValidateFuncionario();
        
        Funcionario novoFuncionario = valid.validaCamposEntrada(nome, sexo, idade,
                cpf, endereco, email, senha, telefone, cidade, bairro);
        
        novoFuncionario.setId(Integer.parseInt(idFuncionario));
        
        repositorio.editar(novoFuncionario);
    }

    public Funcionario buscarFuncionario(String cpf) {
        return (Funcionario) this.repositorio.buscarPorCpf(cpf);
    }

    public void atualizarTabela(JTable grd) {
        List<Funcionario> lst = repositorio.buscarTodos();
        
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
            repositorio.deletar(funcionario);
        } else {
            throw new FuncionarioException("Error - Funcionario inexistente.");
        }
    }    

}

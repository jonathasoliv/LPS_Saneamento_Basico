/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.controller.tableModel.TMCadCliente;
import com.mycompany.saneamento_basico_r.model.entities.Cliente;
import com.mycompany.saneamento_basico_r.model.dao.ClienteDAO;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import com.mycompany.saneamento_basico_r.valid.ValidateCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author JonathasOliveira
 */

public class ClienteController {
    private ClienteDAO repositorio;

    public ClienteController() {
        repositorio = new ClienteDAO();
    }

    public void cadastrarCliente(
            String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro,
            String unidadeConsumidora)
    {
        
        ValidateCliente valid = new ValidateCliente();
        
        Cliente novoCliente = valid.validaCamposEntrada(nome, sexo, idade, cpf,
                endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora);

        if (repositorio.findByEndereco(endereco) == null) {
            repositorio.save(novoCliente);
        } else {
            throw new ClienteException("Error - Já existe um cliente com neste 'endereco'.");
        }
    }

    public void atualizarCliente(int idCliente, String nome, String sexo, String idade, String cpf, String endereco, String email, String senha, String telefone, String cidade, String bairro, String unidadeConsumidora) {
        ValidateCliente valid = new ValidateCliente();
        Cliente novoCliente = valid.validaCamposEntrada(nome, sexo, idade, cpf, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora);
        novoCliente.setId(idCliente);
        
        repositorio.update(novoCliente);
    }

    public Cliente buscarCliente(String endereco) {
        return (Cliente) this.repositorio.findByEndereco(endereco);
    }

    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();
        
        List<Cliente> lstClientes = new ArrayList<>();
        for(Object obj : lst){
            if(obj instanceof Cliente){
                lstClientes.add((Cliente)obj);
            }
        }
        //TMCadCliente tmCliente = new TMCadCliente(lstClientes); CONFERIR SE VAI FUNCIONAR NO SEU PC
        //grd.setModel(tmCliente);        
    }
    

    public void excluirCliente(Cliente cliente) {
        if (cliente != null) {
            repositorio.delete(cliente);
        } else {
            throw new ClienteException("Error - Cliente inexistente.");
        }
    }    

}

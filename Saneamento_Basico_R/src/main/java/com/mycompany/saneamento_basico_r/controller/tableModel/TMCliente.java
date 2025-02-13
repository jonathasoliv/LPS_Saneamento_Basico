/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller.tableModel;

import com.mycompany.saneamento_basico_r.model.entities.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JonathasOliveira
 */
public class TMCliente extends AbstractTableModel {

    private List<Cliente> lista;
    private final int COL_NOME = 0;
    private final int COL_SEXO = 1;
    private final int COL_IDADE = 2;
    private final int COL_CPF = 3;
    private final int COL_ENDERECO = 4;
    private final int COL_EMAIL = 5;
    private final int COL_SENHA = 6;
    private final int COL_TELEFONE = 7;
    private final int COL_CIDADE = 8;
    private final int COL_BAIRRO = 9;
    private final int COL_UNIDADECONSUMIDORA = 10;

    TMCliente(List<Cliente> lstClientes) {
    lista = lstClientes;
}
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8; // Número de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_NOME:
                return cliente.getNome();
            case COL_SEXO:
                return cliente.getSexo();
            case COL_IDADE:
                return cliente.getIdade();
            case COL_CPF:
                return cliente.getCpf();
            case COL_ENDERECO:
                return cliente.getEndereco();
            case COL_EMAIL:
                return cliente.getEmail();
            case COL_SENHA:
                return cliente.getSenha();
            case COL_TELEFONE:
                return cliente.getTelefone();
            case COL_CIDADE:
                return cliente.getCidade();
            case COL_BAIRRO:
                return cliente.getBairro();
            case COL_UNIDADECONSUMIDORA:
                return cliente.getUnidadeConsumidora();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_SEXO:
                return "Sexo";
            case COL_IDADE:
                return "Idade";
            case COL_CPF:
                return "Cpf";
            case COL_ENDERECO:
                return "Endereço";
            case COL_EMAIL:
                return "Email";
            case COL_SENHA:
                return "Senha";
            case COL_TELEFONE:
                return "Telefone";
            case COL_CIDADE:
                return "Cidade";
            case COL_BAIRRO:
                return "Bairro";
            case COL_UNIDADECONSUMIDORA:
                return "Unidade Consumidora";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Defina o tipo de dados das colunas, por exemplo, Integer, String, etc.
        switch (columnIndex) {
            case COL_IDADE:
                return Integer.class;
            default:
                return String.class;
        }
    }

    public Cliente getClienteAt(int rowIndex) {
        return lista.get(rowIndex);
    }
}


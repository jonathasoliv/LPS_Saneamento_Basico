/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller.tableModel;

import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JonathasOliveira
 */
public class TMCadAdministrador extends AbstractTableModel{
    
    private List<Administrador> lista;
    private final int COL_NOME = 0;
    private final int COL_SEXO = 1;
    private final int COL_IDADE = 2;
    private final int COL_CPF = 3;
    private final int COL_DATANASCIMENTO = 4;
    private final int COL_ENDERECO = 5;
    private final int COL_EMAIL = 6;
    private final int COL_SENHA = 7;
    private final int COL_TELEFONE = 8;
    private final int COL_CIDADE = 9;
    private final int COL_BAIRRO = 10;
    private final int COL_UNIDADECONSUMIDORA = 11;

    TMCadAdministrador(List<Administrador> lstAdministrador) {
    lista = lstAdministrador;
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
        Administrador administrador = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_NOME:
                return administrador.getNome();
            case COL_SEXO:
                return administrador.getSexo();
            case COL_IDADE:
                return administrador.getIdade();
            case COL_CPF:
                return administrador.getCpf();
            case COL_DATANASCIMENTO:
                return administrador.getDataNascimento();
            case COL_ENDERECO:
                return administrador.getEndereco();
            case COL_EMAIL:
                return administrador.getEmail();
            case COL_SENHA:
                return administrador.getSenha();
            case COL_TELEFONE:
                return administrador.getTelefone();
            case COL_CIDADE:
                return administrador.getCidade();
            case COL_BAIRRO:
                return administrador.getBairro();
            case COL_UNIDADECONSUMIDORA:
                return administrador.getUnidadeConsumidora();
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
            case COL_DATANASCIMENTO:
                return "Data de Nascimento";
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

    public Administrador getAdministradorAt(int rowIndex) {
        return lista.get(rowIndex);
    }
}

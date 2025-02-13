/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller.tableModel;

import com.mycompany.saneamento_basico_r.model.entities.Funcionario;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JonathasOliveira
 */
public class TMFuncionario extends AbstractTableModel {

    private List<Funcionario> lista;

    private final int id = 0;
    private final int nome = 1;
    private final int sexo = 2;
    private final int idade = 3;
    private final int cpf = 4;
    private final int endereco = 5;
    private final int email = 6;
    private final int senha = 7;
    private final int telefone = 8;
    private final int cidade = 9;
    private final int bairro = 10;
    private final int unidadeConsumidora = 11;
    private final int dataContratacao = 12;

    public TMFuncionario(List<Funcionario> listaFuncionarios) {
        lista = listaFuncionarios;
    }

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case id:
                return "ID";
            case nome:
                return "Nome";
            case sexo:
                return "Sexo";
            case idade:
                return "Idade";
            case cpf:
                return "CPF";
            case endereco:
                return "Endereco";
            case email:
                return "E-mail";
            case senha:
                return "Senha";
            case telefone:
                return "Telefone";
            case cidade:
                return "Cidade";
            case bairro:
                return "Bairro";
            case dataContratacao:
                return "Data de Contratação";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario aux = new Funcionario();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case id:
                    return aux.getId();
                case nome:
                    return aux.getNome();
                case sexo:
                    return aux.getSexo();
                case idade:
                    return aux.getIdade();
                case cpf:
                    return aux.getCpf().replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                case endereco:
                    return aux.getEndereco();
                case email:
                    return aux.getEmail();
                case senha:
                    return aux.getSenha();
                case telefone:
                    return aux.getTelefone();
                case cidade:
                    return aux.getCidade();
                case bairro:
                    return aux.getBairro();
                case dataContratacao:
                    return aux.getDataContratacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                default:
                    return null;
            }
        }
    }

}

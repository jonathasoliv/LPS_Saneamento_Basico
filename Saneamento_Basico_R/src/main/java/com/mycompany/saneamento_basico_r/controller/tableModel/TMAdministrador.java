/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller.tableModel;

import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JonathasOliveira
 */
public class TMAdministrador extends AbstractTableModel {

    private List<Administrador> lista;

    private final int id = 0;
    private final int cpf = 1;
    private final int nome = 2;
    private final int email = 3;
    private final int dataNascimento = 4;
    private final int telefone = 5;
    private final int endereco = 6;

    public TMAdministrador(List<Administrador> listaAdministrador) {
        lista = listaAdministrador;
    }

    @Override
    public int getColumnCount() {
        return 7;
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
            case cpf:
                return "CPF";
            case nome:
                return "Nome";
            case email:
                return "Email";
            case dataNascimento:
                return "Data de Nascimento";
            case telefone:
                return "Telefone";
            case endereco:
                return "Endereço";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Administrador aux = new Administrador();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case id:
                    return aux.getId();
                case cpf:
                    return aux.getCpf().replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                case nome:
                    return aux.getNome();
                case email:
                    return aux.getEmail();
                case dataNascimento:
                    return aux.getDataNascimento() != null
                            ? aux.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                            : "";
                case telefone:
                    return aux.getTelefone();
                case endereco:
                    return aux.getEndereco();
                default:
                    return null;
            }
        }
    }

}

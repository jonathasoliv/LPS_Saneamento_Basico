/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import com.mycompany.saneamento_basico_r.factory.Persistencia;
import com.mycompany.saneamento_basico_r.model.entities.Gerente;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JonathasOliveira
 */

public class GerenteDAO implements IDao{
    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public GerenteDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        Gerente gerente = (Gerente) obj;

        sql = "INSERT INTO gerente(nome, sexo, idade, cpf,"
                + "endereco, email, senha, telefone, cidade,"
                + "bairro, unidadeConsumidora) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, gerente.getNome());
            statement.setString(2, String.valueOf(gerente.getSexo()));
            statement.setInt(3, gerente.getIdade());
            statement.setString(4,gerente.getCpf());
            statement.setString(5, gerente.getEndereco());
            statement.setString(6, gerente.getEmail());
            statement.setString(7, gerente.getSenha());
            statement.setString(8, gerente.getTelefone());
            statement.setString(9, gerente.getCidade());
            statement.setString(10, gerente.getBairro());
            statement.setString(11, gerente.getUnidadeConsumidora());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    
    public void update(Object obj) {
        Gerente gerente = (Gerente) obj;

        sql = "UPDATE gerente "
                + "SET nome=?, sexo=?, idade=?, cpf=?, endereco=?, email=?,"
                + "senha=?, telefone=? , cidade=?, bairro=?, unidadeConsumidora=?"
                + "WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, gerente.getNome());
            statement.setString(2, String.valueOf(gerente.getSexo()));
            statement.setInt(3, gerente.getIdade());
            statement.setString(4,gerente.getCpf());
            statement.setString(5, gerente.getEndereco());
            statement.setString(6, gerente.getEmail());
            statement.setString(7, gerente.getSenha());
            statement.setString(8, gerente.getTelefone());
            statement.setString(9, gerente.getCidade());
            statement.setString(10, gerente.getBairro());
            statement.setString(11, gerente.getUnidadeConsumidora());

            statement.setInt(12, gerente.getId());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public List<Object> findAll() {
        List<Object> list = new ArrayList<>();

        sql = "SELECT * FROM gerente ORDER BY upper(nome)";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Gerente gerente = new Gerente(
                        resultSet.getString("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getString("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("endereco"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("telefone"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("unidadeConsumidora")
                );

                list.add(gerente);
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return list;
    }

    @Override
    public Object find(Object obj) {
        Gerente gerente = (Gerente) obj;

        sql = "SELECT * FROM gerente WHERE id = ?";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setInt(1, gerente.getId());

            ResultSet resultSet = statement.executeQuery();

            Gerente foundGerente = null;
            while (resultSet.next()) {
                foundGerente = new Gerente(
                        resultSet.getString("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getString("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("endereco"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("telefone"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("unidadeConsumidora")
                );
            }
            statement.close();
            return foundGerente;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Object findByEndereco(String email) {
        sql = "SELECT * FROM gerente WHERE endereco = ?";

        Gerente gerente = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                gerente = new Gerente(
                        resultSet.getString("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getString("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("endereco"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("telefone"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("unidadeConsumidora")
                );
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return gerente;
    }

    @Override
    public boolean delete(Object obj) {
        Gerente gerente = (Gerente) obj;

        sql = "DELETE FROM gerente WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, gerente.getId());

            statement.execute();
            statement.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import com.mycompany.saneamento_basico_r.factory.Persistencia;
import com.mycompany.saneamento_basico_r.model.entities.Cliente;
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

public class ClienteDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public ClienteDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        Cliente cliente = (Cliente) obj;

        sql = "INSERT INTO cliente(nome, sexo, idade, cpf, dataNascimento, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());
            statement.setString(2, String.valueOf(cliente.getSexo()));
            statement.setInt(3, cliente.getIdade());
            statement.setString(4,cliente.getCpf());
            statement.setString(5, cliente.getDataNascimento());
            statement.setString(6, cliente.getEndereco());
            statement.setString(7, cliente.getEmail());
            statement.setString(8, cliente.getSenha());
            statement.setString(9, cliente.getTelefone());
            statement.setString(10, cliente.getCidade());
            statement.setString(11, cliente.getBairro());
            statement.setString(12, cliente.getUnidadeConsumidora());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    
    public void update(Object obj) {
        Cliente cliente = (Cliente) obj;

        sql = "UPDATE cliente "
                + "SET nome=?, sexo=?, idade=?, cpf=?, dataNascimento=?, endereco=?, email=?, senha=?, telefone=? , cidade=?, bairro=?, unidadeConsumidora=?"
                + "WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());
            statement.setString(2, String.valueOf(cliente.getSexo()));
            statement.setInt(3, cliente.getIdade());
            statement.setString(4,cliente.getCpf());
            statement.setString(5, cliente.getDataNascimento());
            statement.setString(6, cliente.getEndereco());
            statement.setString(7, cliente.getEmail());
            statement.setString(8, cliente.getSenha());
            statement.setString(9, cliente.getTelefone());
            statement.setString(10, cliente.getCidade());
            statement.setString(11, cliente.getBairro());
            statement.setString(12, cliente.getUnidadeConsumidora());

            statement.setInt(13, cliente.getId());

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

        sql = "SELECT * FROM cliente ORDER BY upper(nome)";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getInt("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("dataNascimento"),
                        resultSet.getString("endereco"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("telefone"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("unidadeConsumidora")
                );

                list.add(cliente);
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
        Cliente cliente = (Cliente) obj;

        sql = "SELECT * FROM cliente WHERE id = ?";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setInt(1, cliente.getId());

            ResultSet resultSet = statement.executeQuery();

            Cliente foundCliente = null;
            while (resultSet.next()) {
                foundCliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getInt("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("dataNascimento"),
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
            return foundCliente;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Object findByEndereco(String email) {
        sql = "SELECT * FROM cliente WHERE endereco = ?";

        Cliente cliente = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getInt("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("dataNascimento"),
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
        return cliente;
    }

    @Override
    public boolean delete(Object obj) {
        Cliente cliente = (Cliente) obj;

        sql = "DELETE FROM cliente WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, cliente.getId());

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


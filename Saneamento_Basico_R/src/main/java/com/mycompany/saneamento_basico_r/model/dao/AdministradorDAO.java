/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import com.mycompany.saneamento_basico_r.factory.Persistencia;
import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JonathasOliveira
 */
public class AdministradorDAO {
    
    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public AdministradorDAO() {
        this.sql = "";
    }

    //@Override
    public void save(Object obj) {
        Administrador administrador = (Administrador) obj;

        sql = "INSERT INTO administrador(nome, sexo, idade, cpf, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, administrador.getNome());
            statement.setString(2, String.valueOf(administrador.getSexo()));
            statement.setInt(3, administrador.getIdade());
            statement.setString(4,administrador.getCpf());
            statement.setString(5, administrador.getEndereco());
            statement.setString(6, administrador.getEmail());
            statement.setString(7, administrador.getSenha());
            statement.setString(8, administrador.getTelefone());
            statement.setString(9, administrador.getCidade());
            statement.setString(10, administrador.getBairro());
            statement.setString(11, administrador.getUnidadeConsumidora());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    
    public void update(Object obj) {
        Administrador administrador = (Administrador) obj;

        sql = "UPDATE administrador "
                + "SET nome=?, sexo=?, idade=?, cpf=?, endereco=?, email=?, senha=?, telefone=? , cidade=?, bairro=?, unidadeConsumidora=?"
                + "WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, administrador.getNome());
            statement.setString(2, String.valueOf(administrador.getSexo()));
            statement.setInt(3, administrador.getIdade());
            statement.setString(4,administrador.getCpf());
            statement.setString(5, administrador.getEndereco());
            statement.setString(6, administrador.getEmail());
            statement.setString(7, administrador.getSenha());
            statement.setString(8, administrador.getTelefone());
            statement.setString(9, administrador.getCidade());
            statement.setString(10, administrador.getBairro());
            statement.setString(11, administrador.getUnidadeConsumidora());

            statement.setInt(12, administrador.getId());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    //@Override
    public List<Object> findAll() {
        List<Object> list = new ArrayList<>();

        sql = "SELECT * FROM administrador ORDER BY upper(nome)";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Administrador administrador = new Administrador(
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

                list.add(administrador);
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return list;
    }

    //@Override
    public Object find(Object obj) {
        Administrador administrador = (Administrador) obj;

        sql = "SELECT * FROM administrador WHERE id = ?";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setInt(1, administrador.getId());

            ResultSet resultSet = statement.executeQuery();

            Administrador foundAdministrador = null;
            while (resultSet.next()) {
                foundAdministrador = new Administrador(
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
            return foundAdministrador;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Object findByEndereco(String email) {
        sql = "SELECT * FROM administrador WHERE endereco = ?";

        Administrador administrador = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                administrador = new Administrador(
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
        return administrador;
    }

    //@Override
    public boolean delete(Object obj) {
        Administrador administrador = (Administrador) obj;

        sql = "DELETE FROM administrador WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, administrador.getId());

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

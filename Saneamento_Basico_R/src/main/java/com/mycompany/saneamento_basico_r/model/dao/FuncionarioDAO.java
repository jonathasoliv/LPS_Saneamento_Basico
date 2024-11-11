/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;


import com.mycompany.saneamento_basico_r.factory.Persistencia;
import com.mycompany.saneamento_basico_r.model.Funcionario;
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
public class FuncionarioDAO implements IDao{
    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public FuncionarioDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        Funcionario funcionario = (Funcionario) obj;

        sql = "INSERT INTO funcionario(nome, sexo, idade, cpf, dataNascimento, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, String.valueOf(funcionario.getSexo()));
            statement.setInt(3, funcionario.getIdade());
            statement.setString(4,funcionario.getCpf());
            statement.setString(5, funcionario.getDataNascimento());
            statement.setString(6, funcionario.getEndereco());
            statement.setString(7, funcionario.getEmail());
            statement.setString(8, funcionario.getSenha());
            statement.setString(9, funcionario.getTelefone());
            statement.setString(10, funcionario.getCidade());
            statement.setString(11, funcionario.getBairro());
            statement.setString(12, funcionario.getUnidadeConsumidora());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    
    public void update(Object obj) {
        Funcionario funcionario = (Funcionario) obj;

        sql = "UPDATE funcionario "
                + "SET nome=?, sexo=?, idade=?, cpf=?, dataNascimento=?, endereco=?, email=?, senha=?, telefone=? , cidade=?, bairro=?, unidadeConsumidora=?"
                + "WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, String.valueOf(funcionario.getSexo()));
            statement.setInt(3, funcionario.getIdade());
            statement.setString(4,funcionario.getCpf());
            statement.setString(5, funcionario.getDataNascimento());
            statement.setString(6, funcionario.getEndereco());
            statement.setString(7, funcionario.getEmail());
            statement.setString(8, funcionario.getSenha());
            statement.setString(9, funcionario.getTelefone());
            statement.setString(10, funcionario.getCidade());
            statement.setString(11, funcionario.getBairro());
            statement.setString(12, funcionario.getUnidadeConsumidora());

            statement.setInt(13, funcionario.getId());

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

        sql = "SELECT * FROM funcionario ORDER BY upper(nome)";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario(
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

                list.add(funcionario);
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
        Funcionario funcionario = (Funcionario) obj;

        sql = "SELECT * FROM funcionario WHERE id = ?";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setInt(1, funcionario.getId());

            ResultSet resultSet = statement.executeQuery();

            Funcionario foundFuncionario = null;
            while (resultSet.next()) {
                foundFuncionario = new Funcionario(
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
            return foundFuncionario;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Object findByEndereco(String email) {
        sql = "SELECT * FROM funcionario WHERE endereco = ?";

        Funcionario funcionario = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                funcionario = new Funcionario(
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
        return funcionario;
    }

    @Override
    public boolean delete(Object obj) {
        Funcionario funcionario = (Funcionario) obj;

        sql = "DELETE FROM funcionario WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, funcionario.getId());

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

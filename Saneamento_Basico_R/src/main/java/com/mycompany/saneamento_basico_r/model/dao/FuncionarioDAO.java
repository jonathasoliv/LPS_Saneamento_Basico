/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;
import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.saneamento_basico_r.factory.DatabaseJPA;
import com.mycompany.saneamento_basico_r.model.entities.Funcionario;

public class FuncionarioDAO implements IDao<Funcionario> {

    private EntityManager entityManager;

    @Override
    public void salvar(Funcionario obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public void editar(Funcionario obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public boolean deletar(Funcionario obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
        return true;
    }

    @Override
    public Funcionario buscar(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Funcionario funcionario = this.entityManager.find(Funcionario.class, id);

        this.entityManager.close();

        return funcionario;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        List<Funcionario> funcionario = this.entityManager
                .createQuery("FROM Funcionario f WHERE f.deletadoEm IS NULL ORDER BY LOWER(m.nome)", Funcionario.class)
                .getResultList();

        this.entityManager.close();
        return funcionario;
    }

    public Funcionario buscarPorCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Funcionario funcionario = this.entityManager
                .createQuery("FROM Funcionario f WHERE f.cpf = :cpf AND f.deletadoEm IS NULL", Funcionario.class)
                .setParameter("cpf", cpf)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return funcionario;
    }

    public Funcionario buscarPorEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Funcionario funcionario = this.entityManager
                .createQuery("FROM Funcionario f WHERE f.email = :email AND f.deletadoEm IS NULL", Funcionario.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return funcionario;
    }

}

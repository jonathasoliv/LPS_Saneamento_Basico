/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.saneamento_basico_r.factory.DatabaseJPA;
import com.mycompany.saneamento_basico_r.model.entities.Cliente;

public class ClienteDAO implements IDao<Cliente> {

    private EntityManager entityManager;

    @Override
    public void salvar(Cliente obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public void editar(Cliente obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();

    }

    @Override
    public boolean deletar(Cliente obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
        return true;
    }

    @Override
    public Cliente buscar(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Cliente cliente = this.entityManager.find(Cliente.class, id);

        this.entityManager.close();

        return cliente;

    }

    @Override
    public List<Cliente> buscarTodos() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        List<Cliente> cliente = this.entityManager
                .createQuery("FROM Cliente c WHERE c.deletadoEm IS NULL ORDER BY LOWER(c.nome)", Cliente.class)
                .getResultList();

        this.entityManager.close();
        return cliente;
    }

    public Cliente buscarPorCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Cliente cliente = this.entityManager
                .createQuery("FROM Cliente c WHERE c.cpf = :cpf AND c.deletadoEm IS NULL", Cliente.class)
                .setParameter("cpf", cpf)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return cliente;
    }

    public Cliente buscarPorEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Cliente cliente = this.entityManager
                .createQuery("FROM Cliente c WHERE c.email = :email AND c.deletadoEm IS NULL", Cliente.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return cliente;
    }

}

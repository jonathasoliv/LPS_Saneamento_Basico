/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.saneamento_basico_r.factory.DatabaseJPA;
import com.mycompany.saneamento_basico_r.model.entities.Administrador;

public class AdministradorDAO implements IDao<Administrador> {

    private EntityManager entityManager;

    @Override
    public void salvar(Administrador obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public void editar(Administrador obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public boolean deletar(Administrador obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
        return true;
    }

    @Override
    public Administrador buscar(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Administrador admin = this.entityManager.find(Administrador.class, id);

        this.entityManager.close();

        return admin;
    }

    @Override
    public List<Administrador> buscarTodos() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        List<Administrador> admins = this.entityManager
                .createQuery("FROM Admin a WHERE a.deletadoEm IS NULL ORDER BY LOWER(a.nome)", Administrador.class)
                .getResultList();

        this.entityManager.close();
        return admins;
    }

    public Administrador buscarPorCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Administrador admin = this.entityManager
                .createQuery("FROM Admin a WHERE a.cpf = :cpf AND a.deletadoEm IS NULL", Administrador.class)
                .setParameter("cpf", cpf)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return admin;
    }

    public Administrador buscarPorEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Administrador admin = this.entityManager
                .createQuery("FROM Admin a WHERE a.email = :email AND a.deletadoEm IS NULL", Administrador.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return admin;
    }
}

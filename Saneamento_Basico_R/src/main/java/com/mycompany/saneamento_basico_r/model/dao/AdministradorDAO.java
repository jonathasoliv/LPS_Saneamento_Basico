/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import com.mycompany.saneamento_basico_r.factory.DatabaseJPA;
import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;


public class AdministradorDao implements IDao<Administrador> {

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
        obj.setDeletadoEm(LocalDateTime.now());
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
        return true;
    }

    @Override
    public Administrador buscar(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Administrador administrador = this.entityManager.find(Administrador.class, id);

        this.entityManager.close();

        return administrador;
    }

    @Override
    public List<Administrador> buscarTodos() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        List<Administrador> administradores = this.entityManager
                .createQuery("FROM Administrador a WHERE a.deletadoEm IS NULL ORDER BY LOWER(a.nome)", Administrador.class)
                .getResultList();

        this.entityManager.close();
        return administradores;
    }

    public Administrador buscarPorCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Administrador administrador = this.entityManager
                .createQuery("FROM Administrador a WHERE a.cpf = :cpf AND a.deletadoEm IS NULL", Administrador.class)
                .setParameter("cpf", cpf)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return administrador;
    }

    public Administrador buscarPorEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Administrador administrador = this.entityManager
                .createQuery("FROM Administrador a WHERE a.email = :email AND a.deletadoEm IS NULL", Administrador.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return administrador;
    }

}

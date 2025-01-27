/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import com.mycompany.saneamento_basico_r.factory.DatabaseJPA;
import com.mycompany.saneamento_basico_r.model.entities.Fatura;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author JonathasOliveira
 */

public class FaturaDao implements IDao<Fatura> {

    private EntityManager entityManager;

    @Override
    public void salvar(Fatura obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public void editar(Fatura obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public boolean deletar(Fatura obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        obj.setDeletadoEm(LocalDateTime.now());
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public Fatura buscar(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Fatura fatura = this.entityManager.find(Fatura.class, id);
        this.entityManager.close();
        return fatura;
    }

    @Override
    public List<Fatura> buscarTodos() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        List<Fatura> faturas = this.entityManager.createQuery(
                "FROM Fatura f WHERE f.deletadoEm IS NULL ORDER BY f.id DESC",
                Fatura.class)
                .getResultList();
        this.entityManager.close();
        return faturas;
    }

    public List<Fatura> buscarPorFatura(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        List<Fatura> faturas = this.entityManager.createQuery(
                "FROM Fatura f WHERE f.deletadoEm IS NULL AND f.cliente.id = :id",
                Fatura.class)
                .setParameter("id", id)
                .getResultList();
        this.entityManager.close();
        return faturas;
    }

    public Fatura buscarPorProcedimento(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Fatura fatura = this.entityManager.createQuery(
                "FROM Fatura f WHERE f.deletadoEm IS NULL AND f.procedimento.id = :id",
                Fatura.class)
                .setParameter("id", id)
                .getResultList().stream().findFirst().orElse(null);
        this.entityManager.close();
        return fatura;
    }

}

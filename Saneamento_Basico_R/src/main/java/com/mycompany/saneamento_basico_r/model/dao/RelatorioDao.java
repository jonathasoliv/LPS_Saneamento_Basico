/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import com.mycompany.saneamento_basico_r.factory.DatabaseJPA;
import com.mycompany.saneamento_basico_r.model.entities.Relatorio;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author JonathasOliveira
 */

public class RelatorioDao implements IDao<Relatorio> {
    private EntityManager entityManager;

    @Override
    public void salvar(Relatorio obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public void editar(Relatorio obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public boolean deletar(Relatorio obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        obj.setDeletadoEm(LocalDateTime.now());
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public Relatorio buscar(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Relatorio relatorio = this.entityManager.find(Relatorio.class, id);
        this.entityManager.close();
        return relatorio;
    }

    @Override
    public List<Relatorio> buscarTodos() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        List<Relatorio> relatorios = this.entityManager.createQuery(
                "FROM Relatorio r WHERE r.deletadoEm IS NULL ORDER BY r.id DESC",
                Relatorio.class)
                .getResultList();
        this.entityManager.close();
        return relatorios;
    }

}

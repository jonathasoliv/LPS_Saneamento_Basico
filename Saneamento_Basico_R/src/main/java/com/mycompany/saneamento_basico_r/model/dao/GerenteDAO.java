/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import com.mycompany.saneamento_basico_r.factory.DatabaseJPA;
import com.mycompany.saneamento_basico_r.model.entities.Gerente;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;

public class GerenteDAO implements IDao<Gerente> {

    private EntityManager entityManager;

    @Override
    public void salvar(Gerente obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public void editar(Gerente obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public boolean deletar(Gerente obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
        return true;
    }

    @Override
    public Gerente buscar(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Gerente gerente = this.entityManager.find(Gerente.class, id);

        this.entityManager.close();

        return gerente;
    }

    @Override
    public List<Gerente> buscarTodos() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        List<Gerente> gerente = this.entityManager
                .createQuery("FROM Gerente g WHERE g.deletadoEm IS NULL ORDER BY LOWER(g.nome)", Gerente.class)
                .getResultList();

        this.entityManager.close();
        return gerente;
    }

    public Gerente buscarPorCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Gerente gerente = this.entityManager
                .createQuery("FROM Gerente g WHERE g.cpf = :cpf AND g.deletadoEm IS NULL", Gerente.class)
                .setParameter("cpf", cpf)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return gerente;
    }

    public Gerente buscarPorEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Gerente gerente = this.entityManager
                .createQuery("FROM Gerente g WHERE g.email = :email AND g.deletadoEm IS NULL", Gerente.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        this.entityManager.close();
        return gerente;
    }

}

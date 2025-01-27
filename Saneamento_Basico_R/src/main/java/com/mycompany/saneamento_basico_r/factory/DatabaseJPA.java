/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.factory;

import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseJPA {

    private EntityManagerFactory factory;

    private static DatabaseJPA INSTANCE = null;

    public static DatabaseJPA getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseJPA();
            INSTANCE.initializeData();
        }

        return INSTANCE;
    }

    private DatabaseJPA() {
        factory = Persistence.createEntityManagerFactory("saneamento-basico");
    }

    private void initializeData() {
        EntityManager em = getEntityManager();
        try {
            try {
                em.createQuery("FROM Administrador a WHERE a.cpf = :cpf AND a.deletadoEm IS NULL", Administrador.class)
                        .setParameter("cpf", "00000000000")
                        .getSingleResult();
            } catch (javax.persistence.NoResultException e) {
                Administrador administrador = new Administrador();
                // Senha padrão: 000000
                em.getTransaction().begin();
                em.persist(administrador);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void closeFactory() {
        this.factory.close();
    }

}

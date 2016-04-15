/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author MATHEUS-NOTE
 */
public class EntityManagerProvider {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    private static EntityTransaction transacao = null;

    private EntityManagerProvider() {
    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("FleetTrackingPU");
            em = emf.createEntityManager();
            transacao = em.getTransaction();
        }
        return em;
    }

    public static EntityTransaction getTransaction() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("FleetTrackingPU");
            em = emf.createEntityManager();
            transacao = em.getTransaction();
        }
        return transacao;
    }

    public static void setEntityManagerFactory(){
        emf = Persistence.createEntityManagerFactory("FleetTrackingPU");
        em = emf.createEntityManager();
        transacao = em.getTransaction();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author MATHEUS-NOTE
 */
public class DAO {
   protected static EntityManager em = EntityManagerProvider.getEntityManager();
   protected static EntityTransaction trans = EntityManagerProvider.getTransaction();
   
   public DAO() { }
 
   public void insert(Object o) throws Exception {
        try {
            trans.begin();
            em.persist(o);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
   }

    public void update(Object o) throws Exception {
        try {
            trans.begin();
            em.merge(o);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }

    public void delete(Object o) throws Exception {
        try {
            trans.begin();
            em.remove(o);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }
    
    public List select(String sqlQuery) throws Exception{
        
        List result;
        
        try{
            trans.begin();
            Query query = em.createQuery(sqlQuery);
            result = query.getResultList();            
            trans.commit();
        } catch (Exception e){
           trans.rollback();
           result = null;
           throw e;
        }
        
        return result;
    }
}

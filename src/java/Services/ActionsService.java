/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Action;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ahmed
 */
@Stateless
public class ActionsService {

    //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    //MARK :: METHODS
    public List<Action> getAll() {
        try {
            String query = "select * from action";
            List<Action> list = em.createNativeQuery(query, Action.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
    public void create(Action action) {
        try {
            et.begin();
            em.persist(action);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    

}

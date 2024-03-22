/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Action;
import Entities.Client;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

      public List<Client> getClientsByProductId(int productId) {
        TypedQuery<Action> query = em.createQuery(
                "SELECT a FROM Action a WHERE a.idProduct.id = :productId", Action.class);
        query.setParameter("productId", productId);
        List<Action> actions = query.getResultList();

        List<Client> clients = actions.stream()
                .map(Action::getIdClient)
                .distinct()  // Ensure unique clients
                .collect(Collectors.toList());

        return clients;
    }
    

}

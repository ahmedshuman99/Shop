/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Client;

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
public class ClientService {

   //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    
    
    //MARK :: METHODS
    public List<Client> getAll() {
        try {
            String query = "select * from client";
            List<Client> list = em.createNativeQuery(query, Client.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
    public void create(Client client) {
        try {
            et.begin();
            em.persist(client);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}

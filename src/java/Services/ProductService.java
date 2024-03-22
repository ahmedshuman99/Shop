/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Client;
import Entities.Product;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ahmed
 */
@Stateless
public class ProductService {

        //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    
    
    //MARK :: METHODS
    public List<Product> getAll() {
        try {
            String query = "select * from product";
            List<Product> list = em.createNativeQuery(query, Product.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
    public void create(Product product) {
        try {
            et.begin();
            em.persist(product);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
   
}

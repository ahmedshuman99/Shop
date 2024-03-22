/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entities.Action;
import Entities.Client;
import Entities.Product;
import Services.ActionsService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "action")
@RequestScoped
public class ActionController implements  Serializable {

    private ActionsService service = new ActionsService ();
    private List<Action>actions = new ArrayList<>();
    private Action action = new Action();
    
    private Integer id;
    private Client idClient;
    private Product idProduct;
    
    private int idClientMode ;
    private int idProductMode;
    private String name;

    public ActionsService getService() {
        return service;
    }

    public void setService(ActionsService service) {
        this.service = service;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdClientMode() {
        return idClientMode;
    }

    public void setIdClientMode(int idClientMode) {
        this.idClientMode = idClientMode;
    }

    public int getIdProductMode() {
        return idProductMode;
    }

    public void setIdProductMode(int idProductMode) {
        this.idProductMode = idProductMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    public List<Action> getAllActions(){
     actions = service.getAll();
     return actions;
    }
    
   public void createNewActions() {
    action.setIdProduct(new Product(idProductMode));
    action.setIdClient(new Client(idClientMode));
    service.create(action);
    actions = service.getAll();
}


   
   
    public List<Client> getClientsByProductId(){
        return service.getClientsByProductId(idProductMode);
    }
    
    
    
    public ActionController() {
    }
    
}

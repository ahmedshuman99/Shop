/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entities.Action;
import Entities.Client;
import Services.ClientService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "client")
@RequestScoped
public class ClientController implements Serializable{

    private ClientService service = new ClientService ();
    private List<Client>Clients = new ArrayList<>();
    private Client client = new Client();
    
    
    private Integer id;
    private String name;
    private Collection<Action> actionCollection;

    public ClientService getService() {
        return service;
    }

    public void setService(ClientService service) {
        this.service = service;
    }

    public List<Client> getClients() {
        return Clients;
    }

    public void setClients(List<Client> Clients) {
        this.Clients = Clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Action> getActionCollection() {
        return actionCollection;
    }

    public void setActionCollection(Collection<Action> actionCollection) {
        this.actionCollection = actionCollection;
    }

    
    
    
    public List<Client> getAllClients(){
    Clients = service.getAll();
    return Clients; 
    }
    
    public void createNewClient(){
    client.setId(id);
    client.setName(name);
    service.create(client); 
    }
    
    
    public ClientController() {
    }
    
}

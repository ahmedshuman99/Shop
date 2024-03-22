/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;


import Entities.Action;
import Entities.Client;
import Entities.Product;
import Services.ProductService;
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
@ManagedBean(name = "product")
@RequestScoped
public class ProductController implements Serializable {

    private ProductService service = new ProductService();
    private List<Product>products = new ArrayList<>();
    private List<Client>Clients = new ArrayList<>();
    private Product product = new Product();
    
    private Integer id;
    private String name;
    private Double price;
    private Collection<Action> actionCollection;
      
    private int selectedProductId;

    public ProductService getService() {
        return service;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Collection<Action> getActionCollection() {
        return actionCollection;
    }

    public void setActionCollection(Collection<Action> actionCollection) {
        this.actionCollection = actionCollection;
    }

    public int getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(int selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public List<Client> getClients() {
        return Clients;
    }

    public void setClients(List<Client> Clients) {
        this.Clients = Clients;
    }

    
    
    
    
    
    public List<Product> getAllProducts(){
     products = service.getAll();
     return products;
    }
    
    public void createNewProduct(){
    product.setName(name);
    product.setPrice(price);
    service.create(product);
    products = service.getAll();
    }
    
   

    public ProductController() {
    }
    
}

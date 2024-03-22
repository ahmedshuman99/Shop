package Entities;

import Entities.Client;
import Entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-22T04:33:14")
@StaticMetamodel(Pay.class)
public class Pay_ { 

    public static volatile SingularAttribute<Pay, Client> idClient;
    public static volatile SingularAttribute<Pay, Product> idProduct;
    public static volatile SingularAttribute<Pay, Integer> id;

}
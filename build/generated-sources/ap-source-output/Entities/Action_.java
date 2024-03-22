package Entities;

import Entities.Client;
import Entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-22T05:45:48")
@StaticMetamodel(Action.class)
public class Action_ { 

    public static volatile SingularAttribute<Action, Client> idClient;
    public static volatile SingularAttribute<Action, Product> idProduct;
    public static volatile SingularAttribute<Action, Integer> id;

}
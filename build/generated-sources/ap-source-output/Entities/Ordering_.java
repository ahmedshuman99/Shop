package Entities;

import Entities.Client;
import Entities.OrderingPK;
import Entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-21T07:06:54")
@StaticMetamodel(Ordering.class)
public class Ordering_ { 

    public static volatile SingularAttribute<Ordering, Product> product;
    public static volatile SingularAttribute<Ordering, Client> client;
    public static volatile SingularAttribute<Ordering, OrderingPK> orderingPK;

}
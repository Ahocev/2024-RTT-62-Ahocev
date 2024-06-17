package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Product;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public Product findById(Integer id) {
        // prepare hibernate session

        Session session = factory.openSession();

        String hql = "select p from Product p where p.id = :id";

        // this is setting up the query (essentially prepared statement)
        TypedQuery<Product> query = session. createQuery(hql,Product.class);
        // substitute incoming id variable into query string
        // select * from products where id
        query.setParameter("id", id);


        try {
            // will throw exception if no records are found
            Product product = query.getSingleResult();

            // if record found we can return it
            return product;
        } catch( Exception e ) {
            // of we land here there was no result
            // this is the standard design pattern
            return null;
        } finally {
            // no matter what happens, close the hibernate session
            session.close();
        }

    }

    public List<Product> findLikeName( String productName ) {

        Session session = factory.openSession();

        // this is referred to HQL or JQL (Hibernate or JPA)
        // HQL USES THE JAVA CLASS NAMES (native query uses SQL)
        // HQL USES THE JAVA CLASS NAMES
        // HQL USES THE JAVA CLASS NAMES
        String hql = "select p from Product p where lower(p.productName) like lower(CONCAT('%', :productName, '%'))";

        // adding the lower function makes it case-insensitive
        // % is a wildcard meaning match any character any number of times

        TypedQuery<Product> query = session. createQuery(hql,Product.class);
        query.setParameter("productName", productName);

        // this will always return a list, so we don't have to worry about it being null
        // if no results, list is empty
        List<Product> result = query.getResultList();

        session.close();

        return result;

    }

    public List<Product> findByName( String productName ) {

        Session session = factory.openSession();

        // this is referred to HQL or JQL (Hibernate or JPA)
        // HQL USES THE JAVA CLASS NAMES (native query uses SQL)
        // HQL USES THE JAVA CLASS NAMES
        // HQL USES THE JAVA CLASS NAMES
        String hql = "select p from Product p where p.productName = :productName";

        TypedQuery<Product> query = session. createQuery(hql,Product.class);
        query.setParameter("productName", productName);

        // this will always return a list, so we don't have to worry about it being null
        // if no results, list is empty
        List<Product> result = query.getResultList();

        session.close();

        return result;

    }

    public void update(Product product) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(product);
        session.getTransaction().commit();
        session.close();
    }

}

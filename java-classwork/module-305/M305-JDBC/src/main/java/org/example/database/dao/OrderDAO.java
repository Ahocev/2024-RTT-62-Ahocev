package org.example.database.dao;

import org.example.database.entity.Order;
import org.hibernate.SessionFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OrderDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void insert(Order order) {

        Session session = factory.openSession();
        session.getTransaction().begin();
        session.save(order);
        session.getTransaction().commit();
        session.close();

    }

    public void update(Order order) {

        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(order);
        session.getTransaction().commit();
        session.close();

    }

    public Order findById(Integer id) {

        Session session = factory.openSession();

        String hql = "SELECT o FROM Order o where o.id = :id";

        TypedQuery<Order> query = session.createQuery(hql, Order.class);

        query.setParameter("id", id);

        try {
            Order result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }

    }

    public List<Order> findByCustomerId(Integer customerId) {
        Session session = factory.openSession();

        String hql = "SELECT o FROM Order o WHERE o.customerId = :customerId";
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        query.setParameter("customerId", customerId);

        List<Order> results;
        try {
            results = query.getResultList();
        } catch (Exception e) {
            results = null;
        } finally {
            session.close();
            factory.close();
        }

        return results;
    }


}

    


package org.example.database.dao;
import org.example.database.entity.Employee;
import org.hibernate.SessionFactory;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

    public class CustomerDAO {

        public static void insert( Customer customer ) {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();

            // begin the transaction
            session.getTransaction().begin();

            // insert the customer to the database
            session.save(customer);

            // commit transaction
            session.getTransaction().commit();

            // cleanup the session
            session.close();

        }

        public List<Customer> findByCustomerName(String customerName) {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();

            String hql = "SELECT c FROM Customer c where c.customerName = :customerName";

            TypedQuery<Customer> query = session. createQuery(hql,Customer.class);

            query.setParameter("customerName", customerName);

            List<Customer> result = query.getResultList();

            session.close();

            return result;

        }

        public List<Customer> findByContactFirstName(String contactFirstName) {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();

            String hql = "SELECT c FROM Customer c where c.contactFirstName = :contactFirstName";

            TypedQuery<Customer> query = session. createQuery(hql,Customer.class);

            query.setParameter("contactFirstName", contactFirstName);

            List<Customer> result = query.getResultList();

            session.close();

            return result;

        }

        public Customer findById(Integer id) {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();

            String hql = "SELECT c FROM Customer c where c.id = :id";

            TypedQuery<Customer> query = session. createQuery(hql,Customer.class);

            query.setParameter("id", id);

            // we know we are querying a pk so the result will be found or not
            // in 2010 this implementation throws an exception if the pk is not found
            try {
                Customer result = query.getSingleResult();
                return result;
            } catch ( Exception e ) {
                return null;
            } finally {
                session.close();
            }

        }

        public void removeDuplicates(String customerName) {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            try {
                String hql = "SELECT c FROM Customer c WHERE c.customerName = :customerName";
                TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
                query.setParameter("customerName", customerName);

                List<Customer> result = query.getResultList();

                // Keep the first result and remove the rest
                if (result.size() > 1) {
                    for (int i = 1; i < result.size(); i++) {
                        session.delete(result.get(i));
                    }
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

        public void update(Employee employee) {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            session.getTransaction().begin();
            session.merge(employee);
            session.getTransaction().commit();
            session.close();
        }

}

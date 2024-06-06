package org.example.database.dao;

import org.hibernate.SessionFactory;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO {

    public static void insert( Employee employee ) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(employee);

        // commit transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();

    }

    public List<Employee> findByFirstName(String firstName) {

        // prepare hibernate session
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA query, syntax slightly diff than SQL
        // SQL = "select * from employees e where e.firstname = ?"
        String hql = "SELECT e FROM Employee e where e.firstname = :firstname";

        // this is how hibernate knows what kind of object to fill with query results
        TypedQuery<Employee> query = session. createQuery(hql,Employee.class);

        // similar to a prepared statement, setting value in the query: firstname
        // to the value passed into the function
        query.setParameter("firstname", firstName);

        // when we know we are getting 0 or more records we use getResultList
        List<Employee> result = query.getResultList();

        // close the hibernate session so it can release the resources its holding
        // specifically close the connection pool and close the transaction
        session.close();

        return result;

    }

    public List<Employee> findByLastName(String lastName) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT e FROM Employee e where e.lastname = :lastname";

        TypedQuery<Employee> query = session. createQuery(hql,Employee.class);

        query.setParameter("lastname", lastName);

        List<Employee> result = query.getResultList();

        session.close();

        return result;

    }

    public Employee findById(Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT e FROM Employee e where e.id = :id";

        TypedQuery<Employee> query = session. createQuery(hql,Employee.class);

        query.setParameter("id", id);

        // we know we are querying a pk so the result will be found or not
        // in 2010 this implementation throws an exception if the pk is not found
        try {
            Employee result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
                return null;
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

    public void delete(Employee employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

}

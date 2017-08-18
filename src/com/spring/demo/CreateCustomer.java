package com.spring.demo;

import com.spring.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateCustomer {

    public static void main(String[] args) {
        // 1. create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        // 2. create session
        Session session = factory.getCurrentSession();


        try {
////////////////    Create    ///////////////////

            // 3. start transaction
            session.beginTransaction();

            // 4.1 CRUD - Create
            Customer cus = new Customer("new", "Demolast", "demo@demoemail.com");

            System.out.println("Read customer record " + cus.toString());

            // 4.1 CRUD - Create
            session.save(cus);


            // 5. commit transaction
            session.getTransaction().commit();

            ////////////////    Read    ///////////////////
            session = factory.getCurrentSession();
            // 3. start transaction
            session.beginTransaction();

            // 4.2 CRUD  - Read
            Customer customer = session.get(Customer.class, cus.getId());

            System.out.println("Read customer record " + customer.toString());

            // 5. commit transaction
            session.getTransaction().commit();


////////////////    Read    ///////////////////
            session = factory.getCurrentSession();
            session.beginTransaction();

            List<Customer> cusList = session.createQuery("from Customer c where c.lastName='Demolast'").getResultList();

            for (Customer c : cusList) {
                System.out.println(c.toString());
            }

            session.getTransaction().commit();



////////////////    Update    ///////////////////
            session = factory.getCurrentSession();
            session.beginTransaction();

            customer = session.get(Customer.class, 1);

            customer.setEmail("newEmailAddress@gmail.com");
            session.getTransaction().commit();



        } finally {
            factory.close();
        }
    }
}

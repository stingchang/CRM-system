package com.spring.demo;

import com.spring.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadCustomerList {

    public static void main(String[] args) {

        // 1. create session factory
        // 2. get session
        // 3. begin transaction
        // 4. CRUD - Read
        // 5. commit

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            ////////////////    Query    ///////////////////
            // 1. get session
//            session = factory.getCurrentSession();
            // 2. begin transaction
            session.beginTransaction();
            // 3. CRUD - Read
            List<Customer> cusList = session.createQuery("from Customer").getResultList();

            for (Customer c : cusList) {
                System.out.println(c.toString());
            }
            // 4. commit
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }

}

package com.spring.demo;

import com.spring.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Update {
    public static void main(String[] args) throws Exception {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            String query = "update Customer set email='default@gmail.com' WHERE cid<=2";
            session.createQuery(query).executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }


    }
}

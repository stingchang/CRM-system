package com.spring.demo;

import com.spring.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Delete {
    public static void main(String[] args) {
        Delete.deleteCustomerRecord(1);
    }

    public static void deleteCustomerRecord(int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Customer cus = session.get(Customer.class, id);
            session.delete(cus);

            // alternative way
            session.createQuery("delete from Customer where cid=2").executeUpdate();


            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}

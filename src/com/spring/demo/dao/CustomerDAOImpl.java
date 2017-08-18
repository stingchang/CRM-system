package com.spring.demo.dao;

import com.spring.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // get session
        Session session  = sessionFactory.getCurrentSession();
        // create query

        Query<Customer> query =session.createQuery("from Customer ", Customer.class);

        // execute query and get result
        List<Customer> customers = query.getResultList();
        // return result
        return customers;
    }
}

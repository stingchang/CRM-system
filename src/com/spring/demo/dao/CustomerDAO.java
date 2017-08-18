package com.spring.demo.dao;

import com.spring.demo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
}
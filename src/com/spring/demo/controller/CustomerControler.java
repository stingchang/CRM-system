package com.spring.demo.controller;

import com.spring.demo.entity.Customer;
import com.spring.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerControler {

    // inject customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model theModel){

        // 1. get customers from dao
        List<Customer> theCustomers = customerService.getCustomers();

        // 2. add customers ot model
        theModel.addAttribute("customers",theCustomers );
        return "list-customers";
    }
}

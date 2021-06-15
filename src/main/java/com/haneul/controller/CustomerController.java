package com.haneul.controller;

import com.haneul.dao.CustomerDAO;
import com.haneul.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String listCustomers(Model theModel){

        List<Customer> customerList = customerDAO.getCustomers();

        theModel.addAttribute("customerList",customerList);

        return "list-customers";
    }
}

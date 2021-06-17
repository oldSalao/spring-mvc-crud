package com.haneul.controller;

import com.haneul.dao.CustomerDAO;
import com.haneul.entity.Customer;
import com.haneul.service.CustomerService;
import com.haneul.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> customerList = customerService.getCustomers();

        theModel.addAttribute("customerList", customerList);

        return "list-customers";
    }
}

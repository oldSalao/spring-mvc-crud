package com.haneul.service;

import com.haneul.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer theCustomer);

}

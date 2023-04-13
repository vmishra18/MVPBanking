package com.nagarro.customer.service.service;

import com.nagarro.customer.service.entities.Customer;

import java.util.List;

public interface CustomerService {


    Customer saveCustomer(Customer customer);


    List<Customer> getAllCustomers();


    Customer getCustomer(Long id);


    int updateCustomer(Long id ,Customer customer);


    Customer deleteCustomer(Long id);

    List<Object[]> getCustomerbyaccount(String  acc);



}
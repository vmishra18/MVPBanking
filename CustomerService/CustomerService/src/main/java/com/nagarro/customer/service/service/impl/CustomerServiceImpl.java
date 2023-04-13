package com.nagarro.customer.service.service.impl;

import com.nagarro.customer.service.entities.Customer;
import com.nagarro.customer.service.exception.ResourceNotFoundException;
import com.nagarro.customer.service.repositories.UserRepo;
import com.nagarro.customer.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Customer saveCustomer(Customer customer) {
        return userRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return userRepo.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer with the following ID was not found: " + id));
    }

    @Override
    public int updateCustomer( Long id, Customer customer){
        return userRepo.updateCustomer(customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail(), id);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customer = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer with the following ID was not found: " + id));
        if (customer != null) {
            userRepo.delete(customer);
        }
        return customer;
    }


    @Override
    public List<Object[]> getCustomerbyaccount(String acc){
        List<Object[]> customer = userRepo.findbybyaccount(acc);
        return customer;
    }

}


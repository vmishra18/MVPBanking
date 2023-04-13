package com.nagarro.customer.service.dto;

import com.nagarro.customer.service.entities.Customer;

public class CustomerDetailDto {

    private Customer customer;

    private AccountDto account;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    public CustomerDetailDto(Customer customer, AccountDto account) {
        super();
        this.customer = customer;
        this.account = account;
    }

}


package com.nagarro.accountservice.AccountManagement.dto;

import com.nagarro.accountservice.AccountManagement.entities.Account;

public class AccountDetailDto {
    private CustomerDto customer;

    private Account account;



    public AccountDetailDto(CustomerDto customer, Account account) {
        super();
        this.customer = customer;
        this.account = account;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}

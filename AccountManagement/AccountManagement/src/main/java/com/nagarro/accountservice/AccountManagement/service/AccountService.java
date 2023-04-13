package com.nagarro.accountservice.AccountManagement.service;

import com.nagarro.accountservice.AccountManagement.dto.AccountDto;
import com.nagarro.accountservice.AccountManagement.entities.Account;
import com.nagarro.accountservice.AccountManagement.exception.ResourceNotFoundException;
import com.nagarro.accountservice.AccountManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Optional<Account> getAccount(String account) {
        return accountRepository.findById(account);
    }

    public Account saveAccount(Account accountDto) {
        return accountRepository.save(accountDto);
    }
    public int updatebalance(double amount, String acc){
        return accountRepository.updatebalance(amount,acc);
    }

    public Account deleteCustomer(String id) {
        Account customer = accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer with the following ID was not found: " + id));
        if (customer != null) {
            accountRepository.delete(customer);
        }
        return customer;
    }
}

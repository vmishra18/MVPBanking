package com.nagarro.accountservice.AccountManagement.entities;





import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.List;


@Entity
@Table(name = "account", schema = "online_bank")
public class Account {

    @Id
    @Column(unique = true, nullable = false)
    private String account;

    @Column(nullable = false)
    private String customer;

    @Column(nullable = false, precision = 2)
    private double balance;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}


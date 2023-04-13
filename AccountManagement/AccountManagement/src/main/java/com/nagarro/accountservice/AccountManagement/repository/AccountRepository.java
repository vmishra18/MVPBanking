package com.nagarro.accountservice.AccountManagement.repository;

import com.nagarro.accountservice.AccountManagement.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface AccountRepository extends JpaRepository<Account, String> {
    @Transactional
    @Modifying
    @Query("UPDATE Account c SET c.balance = ?1 WHERE account = ?2")
    int updatebalance(double amount, String acc);
}

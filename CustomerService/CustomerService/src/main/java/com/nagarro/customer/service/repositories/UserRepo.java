package com.nagarro.customer.service.repositories;
import com.nagarro.customer.service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface UserRepo extends JpaRepository<Customer, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.firstName = ?1, c.lastName = ?2, c.phone = ?3, c.email = ?4 WHERE id = ?5")
    int updateCustomer(String FirstName, String LastName, String Phone, String Email, Long id);


    @Query("SELECT t FROM Customer t WHERE t.accountno = ?1")
    List<Object[]> findbybyaccount(String acc);
}

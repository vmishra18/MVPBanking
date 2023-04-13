package com.nagarro.customer.service.controller;
import com.nagarro.customer.service.dto.AccountDto;
import com.nagarro.customer.service.entities.*;
import com.nagarro.customer.service.external.service.AccountService;
import com.nagarro.customer.service.service.CustomerService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired(required=true)
//    private AccountServiceProxy accountServiceProxy;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        List<Object[]> res = customerService.getCustomerbyaccount(customer.getAccountno());
        if(res.isEmpty()){
            Customer customerObj = customerService.saveCustomer(customer);
            AccountDto a = new AccountDto();
            a.setCustomer(customer.getFirstName());
            a.setAccount(customer.getAccountno());
            a.setBalance(0);
            ResponseEntity<AccountDto> responseEntity = restTemplate.postForEntity("http://ACCOUNT-SERVICE/accounts/account",a,AccountDto.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(customerObj);
        }
        else {
            return new ResponseEntity<>( HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }



    @GetMapping("/{id}")
    public ResponseEntity<Customer> getSingleUser(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer) {
        int customerObj = customerService.updateCustomer(id,customer);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
       restTemplate.delete("http://ACCOUNT-SERVICE/accounts/" +customer.getAccountno());
        Customer cs = customerService.deleteCustomer(id);
        return ResponseEntity.ok(cs);
    }
    @GetMapping("/bankaccount")
    public ResponseEntity<Object[]> getAccountDetailByAccountNumber(@RequestParam String account) {

        List<Object[]> customer = customerService.getCustomerbyaccount(account);
        return ResponseEntity.ok(customer.get(0));
    }
}
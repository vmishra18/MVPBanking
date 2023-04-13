package com.nagarro.accountservice.AccountManagement.service;

import com.nagarro.accountservice.AccountManagement.dto.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CustomerServiceProxy {
    @GetMapping(value = "/customer-detail")
    public CustomerDto getCustomerById(@RequestParam(name = "id") String id);
}

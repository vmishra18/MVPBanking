package com.nagarro.accountservice.AccountManagement.external.service;

import com.nagarro.accountservice.AccountManagement.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "User-Service")
public interface CustomerService {
    @GetMapping("/bankaccount/{account}")
    CustomerDto getAccount(@PathVariable("account") String account);
}

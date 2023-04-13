package com.nagarro.customer.service.external.service;

import com.nagarro.customer.service.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Account-Service")
public interface AccountService {
    @GetMapping("/account/{account}")
    AccountDto getAccount(@PathVariable("account") String account);
}

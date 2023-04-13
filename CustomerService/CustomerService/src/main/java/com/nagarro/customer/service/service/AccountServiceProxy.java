package com.nagarro.customer.service.service;

import com.nagarro.customer.service.dto.AccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
public interface AccountServiceProxy {
    @GetMapping(value = "/account-detail")
    public AccountDto getAccountByAccountNo(@RequestParam(name = "account") String account);

}

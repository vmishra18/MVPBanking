package com.nagarro.accountservice.AccountManagement.controller;
import com.nagarro.accountservice.AccountManagement.entities.Account;
import com.nagarro.accountservice.AccountManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/bankaccount")
    public ResponseEntity<Object> getAccountDetailByAccountNumber(@RequestParam String account) {

        Optional<Account> accountDetail = accountService.getAccount(account);

        if (accountDetail.isEmpty()) {
            System.out.println("is empty "+ accountDetail);
            return new ResponseEntity<>("No account found", HttpStatus.NOT_FOUND);
        }
        ResponseEntity<Object[]> responseEntity = restTemplate
                .getForEntity("http://USER-SERVICE/customers/bankaccount?account=" + account,
                        Object[].class);
        List<Object> c = new ArrayList<>();
        c.addAll(Collections.singleton(accountDetail));
        c.addAll(List.of(responseEntity.getBody()));

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<Object> addNewAccount(@RequestBody Account account) {
        Account res = accountService.saveAccount(account);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/addbalance")
    public  ResponseEntity<Object> addbalance(@RequestBody Account account){
        String accountno = account.getAccount();
        Optional<Account> accountDetail = accountService.getAccount(accountno);

        if (accountDetail.isEmpty()) {
            return new ResponseEntity<>("No account found", HttpStatus.NOT_FOUND);
        }
        int res =  accountService.updatebalance(accountDetail.get().getBalance()+ account.getBalance(),account.getAccount());

        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @PostMapping("/withdrawal")
    public  ResponseEntity<Object> withdrawalbalance(@RequestBody Account account){
        String accountno = account.getAccount();
        Optional<Account> accountDetail = accountService.getAccount(accountno);

        if (accountDetail.isEmpty()) {
            return new ResponseEntity<>("No account found", HttpStatus.NOT_FOUND);
        }
        if (accountDetail.get().getBalance() >= account.getBalance() ) {
            double res = accountService.updatebalance(accountDetail.get().getBalance() - account.getBalance(), account.getAccount());

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>("Not a sufficient balance to withdraw", HttpStatus.OK);

    }
    @DeleteMapping("/{accountno}")
    public ResponseEntity<Account> deleteaccount(@PathVariable String  accountno) {
        Account customer = accountService.deleteCustomer(accountno);
        return ResponseEntity.ok(customer);
    }
}

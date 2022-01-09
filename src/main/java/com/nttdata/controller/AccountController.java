package com.nttdata.controller;

import com.nttdata.model.Account;
import com.nttdata.service.AccountService;
import com.nttdata.service.AccountServiceImpl;
import com.nttdata.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountServiceImpl;
    @Autowired
    private ClientService clientService;
    
   // @PostMapping("/test")
    @GetMapping(value = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount() {
    	logger.info("creating customer");
    	clientService.verifyClient(1);
        //accountServiceImpl.createAccount(account);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody Account account) {
    	logger.info("creating customer");
        accountServiceImpl.createAccount(account);
    }

    @GetMapping(value = "/accounts", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Account> findAll() {
    	logger.info("find accounts");
        return accountServiceImpl.findAllAccount();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Mono<Account>> findEmpById(@PathVariable("id") Integer id) {
        Mono<Account> employee = accountServiceImpl.findByAccountId(id);
        return new ResponseEntity<Mono<Account>>(employee, employee != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    

}

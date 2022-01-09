package com.nttdata.service;

import com.nttdata.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface AccountService
{
    void createAccount(Account e);
     
    Mono<Account> findByAccountId(Integer id);
 
    Flux<Account> findAllAccount();
 
    //Mono<Account> updateCustomer(Account e);
 
   // Mono<Void> deleteCustomer(Integer id);
}
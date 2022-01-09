package com.nttdata.service;

import com.nttdata.dao.ProductRepository;
import com.nttdata.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    ProductRepository customerRepo;

    public void createAccount(Account employee) {
        customerRepo.save(employee).subscribe();
    }

    public Mono<Account> findByAccountId(Integer id) {
        return customerRepo.findById(id);
    }

    public Flux<Account> findAllAccount() {
        return customerRepo.findAll();
    }

//    public Mono<Account> updateCustomer(Account employee) {
//        return customerRepo.save(employee);
//    }
//
//    public Mono<Void> deleteCustomer(Integer id) {
//        return customerRepo.deleteById(id);
//    }

	
}
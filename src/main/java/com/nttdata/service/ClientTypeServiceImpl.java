package com.nttdata.service;

import com.nttdata.dao.ClientTypeRepository;
import com.nttdata.dao.ProductRepository;
import com.nttdata.model.ClientType;
import com.nttdata.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientTypeServiceImpl implements ClientTypeService {

    @Autowired
    ClientTypeRepository repository;

    public void createClientType(ClientType e) {
        repository.save(e).subscribe();
    }

    public Mono<ClientType> findByClientType(Integer id) {
        return repository.findById(id);
    }

    public Flux<ClientType> findAllClientType() {
        return repository.findAll();
    }

    public Mono<ClientType> updateClientType(ClientType e) {
        return repository.save(e);
    }

    public Mono<Void> deleteClientType(Integer id) {
        return repository.deleteById(id);
    }

	
}
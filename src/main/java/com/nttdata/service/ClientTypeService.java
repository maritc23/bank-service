package com.nttdata.service;

import com.nttdata.model.ClientType;
import com.nttdata.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface ClientTypeService
{
    void createClientType(ClientType e);
     
    Mono<ClientType> findByClientType(Integer id);
 
    Flux<ClientType> findAllClientType();
 
    Mono<ClientType> updateClientType(ClientType e);
 
    Mono<Void> deleteClientType(Integer id);
}
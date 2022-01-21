package com.nttdata.dao;

import com.nttdata.model.ClientType;
import com.nttdata.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTypeRepository extends ReactiveMongoRepository<ClientType, Integer> {
}
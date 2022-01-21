package com.nttdata.controller;

import com.nttdata.model.ClientType;
import com.nttdata.model.Product;
import com.nttdata.service.ClientTypeService;
import com.nttdata.service.ProductService;
import com.nttdata.service.ProductServiceImpl;
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
public class BankController {
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private ProductService productService;
    @Autowired
    private ClientTypeService clientTypeService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Product employee) {
    	logger.info("creating customer");
        productService.createCustomer(employee);
    }

    @GetMapping(value = "/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Product> findAll() {
    	logger.info("find customers");
        return productService.findAllCustomer();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Mono<Product>> findEmpById(@PathVariable("id") Integer id) {
        Mono<Product> employee = productService.findByCustomerId(id);
        return new ResponseEntity<Mono<Product>>(employee, employee != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> update(@RequestBody Product employee) {
    	
        return productService.updateCustomer(employee);
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        productService.deleteCustomer(id).subscribe();
    }
    
    @GetMapping(value = "/client-types", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<ClientType> findAllClientType() {
    	logger.info("find client type");
        return clientTypeService.findAllClientType();
    }
    
    @PostMapping("/client-types")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClientType(@RequestBody ClientType type) {
    	logger.info("creating client type");
    	clientTypeService.createClientType(type);
    }
}

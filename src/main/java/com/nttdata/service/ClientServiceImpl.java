package com.nttdata.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.model.Account;
import com.nttdata.model.Customer;

import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	
	private final WebClient webClient;
	
	public ClientServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:8081/").build();
	}
	
	public boolean verifyClient(Integer id) {
		Mono<Customer> customerMono = this.webClient.get().uri("customers/{id}", id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(Customer.class).log();
		Customer customer = customerMono.block();
		if(customer!=null)
			return true;
		return false;
    }

	
}	

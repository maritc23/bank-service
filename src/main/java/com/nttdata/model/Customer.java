package com.nttdata.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	int id;
    String name;
    String lastname;
    String documentType;
    String documentNumber;
    String phoneNumber;
    String email;
    String clientType;
}

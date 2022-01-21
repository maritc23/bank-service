package com.nttdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Product {
    @Id
    int id;
    String productType;
    String productName;
    Boolean applyMaintenanceCommission;
    Double maintenanceCommission;
    Boolean applyMaxMonthlyMovements;
    Integer maxMonthlyMovements;
    Integer allowedMovementDate;
    Integer maxAllowedProductsPerClient;
    String allowedClientType;
    

}

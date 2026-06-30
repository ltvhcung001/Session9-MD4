package com.rikkeiedu.pharmacyservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @CircuitBreaker(name = "warehouseCB", fallbackMethod = "fallbackCheckInventory")
    public String checkInventory(String medicineId) {
        // Simulate a call to warehouse-service that fails
        throw new RuntimeException("Warehouse service is down");
    }

    public String fallbackCheckInventory(String medicineId, Throwable t) {
        return "Fallback: Inventory check failed for " + medicineId + ". Reason: " + t.getMessage();
    }
}

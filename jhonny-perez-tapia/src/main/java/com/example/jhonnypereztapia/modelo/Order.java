package com.example.jhonnypereztapia.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerName;
    private String customerEmail;
    private String status = "confirmado";
    private LocalDateTime creationTime = LocalDateTime.now();
    private LocalDateTime estimatedDeliveryTime = creationTime.plusMinutes(30);
    private List<Food> items;

    public Order(String id, String customerName, String customerEmail, List<Food> items) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public List<Food> getItems() {
        return items;
    }

    public double getTotal() {
        return items.stream().mapToDouble(Food::getPrecio).sum();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }
}
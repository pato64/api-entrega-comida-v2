package com.example.jhonnypereztapia.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.jhonnypereztapia.modelo.Food;
import com.example.jhonnypereztapia.modelo.Order;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public Order createOrder(String customerName, String customerEmail, List<Food> items) {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, customerName, customerEmail, items);
        orders.add(order);
        return order;
    }

    public Order getOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void updateOrderStatus(String orderId, String newStatus) {
        Order order = getOrderById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("No se pudo encontrar el pedido con ID: " + orderId);
        }
        order.setStatus(newStatus);
        if (newStatus.equals("enviado")) {
            order.setEstimatedDeliveryTime(LocalDateTime.now().plusMinutes(60));
        }
    }

    public void deleteOrder(String orderId) {
        Order order = getOrderById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("No se pudo encontrar el pedido con ID: " + orderId);
        }
        orders.remove(order);
    }
}

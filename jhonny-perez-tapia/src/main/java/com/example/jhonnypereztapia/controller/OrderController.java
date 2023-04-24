package com.example.jhonnypereztapia.controller;

import com.example.jhonnypereztapia.modelo.Food;
import com.example.jhonnypereztapia.modelo.Order;
import com.example.jhonnypereztapia.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    private List<Food> menu = new ArrayList<>();

    public OrderController() {
        menu.add(new Food("hamburguesa", "un pan de hamburguesa con carne, huevo, tomate,queso ", 8.00));
        menu.add(new Food("Chicha morada", "Bebida popular en el Peru dulce y deliciosa", 15.20));
        menu.add(new Food("tequeños", "rrellenos de salchicha estan buenos", 8.00));
        menu.add(new Food("salchipapa", "combinado entre papas y salchicha con cremas al gusto", 12.00));
    }

    @GetMapping("")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("")
    public Order createOrder(@RequestParam String customerName,
                             @RequestParam String customerEmail,
                             @RequestBody List<Food> items) {
        return orderService.createOrder(customerName, customerEmail, items);
    }

    @PutMapping("/{orderId}")
    public void updateOrderStatus(@PathVariable String orderId,
                                  @RequestParam String newStatus) {
        orderService.updateOrderStatus(orderId, newStatus);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
    }
}

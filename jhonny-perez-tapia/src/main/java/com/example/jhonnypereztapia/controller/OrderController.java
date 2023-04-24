package com.example.jhonnypereztapia.controller;

import com.example.jhonnypereztapia.modelo.Food;
import com.example.jhonnypereztapia.modelo.Order;
import com.example.jhonnypereztapia.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

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

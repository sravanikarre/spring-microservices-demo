package com.springmircoservies.order_service.controller;



import com.springmircoservies.order_service.entity.Order;
import com.springmircoservies.order_service.entity.Product;
import com.springmircoservies.order_service.feign.ProductClient;
import com.springmircoservies.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @GetMapping
    public List<Order> getAll() {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(order -> {
            Product product = productClient.getProductById(order.getProductId());
            order.setProduct(product);
        });
        return orders;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        Product product = productClient.getProductById(order.getProductId());
        order.setTotalPrice(product.getProductPrice() * order.getQuantity());
        order.setProduct(product);
        return orderRepository.save(order);
    }
}


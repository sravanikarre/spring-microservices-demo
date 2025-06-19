package com.springmircoservies.order_service.feign;


import com.springmircoservies.order_service.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products/{productId}")
    Product getProductById(@PathVariable Integer productId);
}


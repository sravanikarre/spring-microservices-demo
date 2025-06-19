package com.springmircoservies.product_service.controller;

import com.springmircoservies.product_service.entity.Product;
import com.springmircoservies.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/get-products")
    public List<Product> getAllProducts(){
        System.out.println(productRepository.findAll());
      return  productRepository.findAll();

    }


    @GetMapping("/{id}")
    public Product getAllProducts(@PathVariable Integer id){

        return  productRepository.findById(id).orElse(null);

    }
    @PostMapping("/create")
    public void createProduct(@RequestBody Product product)
    {
        productRepository.save(product);
    }
}

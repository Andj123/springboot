package com.product.springdemo.controller;

import com.product.springdemo.Service.ProductService;
import com.product.springdemo.model.Product;
import com.product.springdemo.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable final int id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody final ProductRequest product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

}



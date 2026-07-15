package com.Lalit.simpleWebApp.controller;

import com.Lalit.simpleWebApp.model.Product;
import com.Lalit.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService prodService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return prodService.getProduct();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return prodService.getById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        prodService.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        prodService.updateProduct(prod);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        prodService.deleteProduct(id);
    }

}

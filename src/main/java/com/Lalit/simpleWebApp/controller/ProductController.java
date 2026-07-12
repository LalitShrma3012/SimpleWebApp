package com.Lalit.simpleWebApp.controller;

import com.Lalit.simpleWebApp.model.Product;
import com.Lalit.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService prodService;

    @RequestMapping("/products")
    public List<Product> getProducts(){
        return prodService.getProduct();
    }
}

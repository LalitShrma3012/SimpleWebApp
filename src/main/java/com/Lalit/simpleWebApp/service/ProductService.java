package com.Lalit.simpleWebApp.service;

import com.Lalit.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(101, "IPhone", 50000),
            new Product(102, "Canon Camera", 600000),
            new Product(103, "Asus VivoBook", 120000)
    );

    public List<Product> getProduct(){
        return products;
    }
}

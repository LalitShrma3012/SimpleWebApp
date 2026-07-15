package com.Lalit.simpleWebApp.service;

import com.Lalit.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "IPhone", 50000),
            new Product(102, "Canon Camera", 600000),
            new Product(103, "Asus VivoBook", 120000))
    );

    public List<Product> getProduct(){
        return products;
    }

    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getProdId()==id)
                .findFirst().orElse(new Product(100, "No Item", 0));
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateProduct(Product prod) {
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getProdId() == prod.getProdId()){
                products.set(i, prod);
                return;
            }
        }
    }

    public void deleteProduct(int id) {
        int idx = 0;
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getProdId() == id){
                idx = i;
                break;
            }
        }
        products.remove(products.get(idx));
    }
}

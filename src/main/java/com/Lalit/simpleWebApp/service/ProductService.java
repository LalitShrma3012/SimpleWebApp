package com.Lalit.simpleWebApp.service;


import com.Lalit.simpleWebApp.model.Product;
import com.Lalit.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        if(imageFile!=null && !imageFile.isEmpty()) {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
        }
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Product existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found " + id));
        existing.setName(product.getName());
        existing.setBrand(product.getBrand());
        existing.setDescription(product.getDescription());
        existing.setAvailable(product.isAvailable());
        existing.setReleaseDate(product.getReleaseDate());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        existing.setStockQuantity(product.getStockQuantity());
        if(imageFile!=null && !imageFile.isEmpty()) {
            existing.setImageData(imageFile.getBytes());
            existing.setImageName(imageFile.getOriginalFilename());
            existing.setImageType(imageFile.getContentType());
        }
        return repo.save(existing);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }



    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}

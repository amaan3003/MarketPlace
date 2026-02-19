package com.chaiaurcamera.marketplace.service;

import com.chaiaurcamera.marketplace.model.Product;
import com.chaiaurcamera.marketplace.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Is method ka naam sahi rakhna taaki controller ise call kar sake
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
package com.product.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public void saveProduct(Product product){
    	productRepository.save(product);
    }
    
    public List<Product> allProducts(){
    	return productRepository.findAll();
    }
}

package com.example.OrderManagement.service;

import com.example.OrderManagement.model.Product;
import com.example.OrderManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product Not Found..!"));
    }

    public Product updateProduct(Product product,Long id){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product Not Found..!"));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product Successfully deleted..!!";
    }
}

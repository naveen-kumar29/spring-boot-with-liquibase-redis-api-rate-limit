package com.example.liquibase.graphql.service;

import java.util.List;

import com.example.liquibase.graphql.entites.Product;
import com.example.liquibase.graphql.entites.ProductInput;
import com.example.liquibase.graphql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public List<Product> getProductsByName(String name) {
        return repository.findByName(name);
    }

    public Product updatePrice(int id, float price) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id " + id));

        existingProduct.setPrice(price);

        repository.save(existingProduct);

        return existingProduct;
    }

    public Product addProduct(ProductInput product) {
        Product enproduct = new Product();
        enproduct.setCategory(product.getCategory());
        enproduct.setId(product.getId());
        enproduct.setName(product.getName());
        enproduct.setPrice(product.getPrice());
        enproduct.setStock(product.getStock());

        return repository.save(enproduct);
    }

    public Product updateProduct(ProductInput stock) {
        Product existingProduct = repository.findById(stock.getId())
                .orElseThrow(() -> new RuntimeException("product not found with id " + stock.getId()));

        existingProduct.setStock(stock.getStock());
        existingProduct.setPrice(stock.getPrice());

        return repository.save(existingProduct);
    }

    public String deleteProductById(int id) {
        repository.deleteById(id);
        return "Deleted Successfully";
    }

}

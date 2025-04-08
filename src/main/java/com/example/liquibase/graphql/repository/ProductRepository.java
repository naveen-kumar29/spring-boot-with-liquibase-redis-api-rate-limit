package com.example.liquibase.graphql.repository;

import com.example.liquibase.graphql.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

}

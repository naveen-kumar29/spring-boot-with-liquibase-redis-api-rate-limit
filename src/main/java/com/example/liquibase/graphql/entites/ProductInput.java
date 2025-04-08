package com.example.liquibase.graphql.entites;


import lombok.Data;

@Data
public class ProductInput {
    private int id;
    private String name;
    private String category;
    private float price;
    private int stock;

}
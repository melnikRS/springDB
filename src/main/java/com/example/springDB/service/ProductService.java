package com.example.springDB.service;

import com.example.springDB.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProduct(String name);
}

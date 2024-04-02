package com.example.springDB.repositpry;

import com.example.springDB.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getProduct(String name);
}

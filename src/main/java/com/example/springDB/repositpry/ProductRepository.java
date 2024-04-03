package com.example.springDB.repositpry;

import java.util.List;

public interface ProductRepository {
    public List<String> getProduct(String name);
}

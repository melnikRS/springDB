package com.example.springDB.service;

import com.example.springDB.model.Product;
import com.example.springDB.repositpry.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    @Override
    public List<Product> getProduct(String name) {
        return repository.getProduct(name);
    }
}

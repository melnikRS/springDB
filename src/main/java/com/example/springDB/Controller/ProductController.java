package com.example.springDB.Controller;

import com.example.springDB.model.Product;
import com.example.springDB.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/fetch-product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/{name}")
    public List<Product> getById(@PathVariable String name) {
        return productService.getProduct(name);
    }
}

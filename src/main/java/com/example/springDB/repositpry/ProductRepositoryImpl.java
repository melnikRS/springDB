package com.example.springDB.repositpry;

import com.example.springDB.mapper.ProductMapper;
import com.example.springDB.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository{

    private String sqlText;
    private final NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Override
    public List<Product> getProduct(String name) {
        sqlText = read("query.sql");
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);
        return parameterJdbcTemplate.query(sqlText, param, new ProductMapper());
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

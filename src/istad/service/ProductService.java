package istad.service;

import istad.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);

    void deleteByCode(String code);

    void updateByCode(String code, Product product);

    List<Product> findAll();
}

package istad.service;

import istad.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);


    void deleteById(String code);

    List<Product> findAll();
}

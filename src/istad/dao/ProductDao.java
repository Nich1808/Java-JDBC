package istad.dao;

import istad.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    //for insert
    //1. Operation : Insert a new record into db
    //2. Expected return value -> affected row number
    //3. Parameters
    int save(Product product) throws SQLException;

    //for delete
    int deleteByCode(String code) throws  SQLException;

    //for update
    //1.Operation: check product by code
    //2. Expected return value: boolean
    //3. Parameter: code
    boolean existsByCode(String code) throws SQLException;

    //1. Operation: Select product by code
    //2. Expected return value: single object of product
    //3. Parameter: code
    Optional<Product> findByCode(String code) throws SQLException;


    //1. Operation : Update an existing record bby code in db
    //2. Expected return value -> affected row number
    //3. Parameter: code , product
    int updateByCode(String code, Product product) throws SQLException;



    //findAll
    //1. Operation: read all record from db
    //2. Expected return value -> multiple record
    //3. Parameters
    List<Product> findAll() throws SQLException;

}

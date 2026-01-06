package istad.dao;

import istad.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    //1. Operation : Insert a new record into db
    //2. Expected return value -> affected row number
    //3. Parameters
    int save(Product product) throws SQLException;


    //for delete
    int deleteById(String code) throws  SQLException;




    //1. Operation: read all record from db
    //2. Expected return value -> multiple record
    //3. Parameters
    List<Product> findAll() throws SQLException;

}

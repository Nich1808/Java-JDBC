package istad.service;

import istad.dao.ProductDao;
import istad.dao.ProductDaoImpl;
import istad.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    public ProductServiceImpl() {
        productDao = new ProductDaoImpl();
    }

    @Override
    public void save(Product product) {
        try {
            int affectedRow = productDao.save(product);
            if (affectedRow < 1)
                throw new RuntimeException("Save Operetion failed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteById(String code) {
        try {
            int affectedRow = productDao.deleteById(code);
            if(affectedRow > 0){
                System.out.println("Deleted Succesfull!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() {
        try{
            return productDao.findAll();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

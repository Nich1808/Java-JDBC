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

    //insert
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

    //delete
    @Override
    public void deleteByCode(String code) {
        try {
            int affectedRow = productDao.deleteByCode(code);
            if(affectedRow > 0){
                System.out.println("Deleted Succesfull!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        }
    }

    //update
    @Override
    public void updateByCode(String code, Product product) {
        try{
            ////style 1 : validate product existing or not by code
            // if(!productDao.existsByCode(code))
            // throw new RuntimeException("Product code doesn't exist...!");

            //style2 : validate product existing or not by code
            Product existingProduct = productDao.findByCode(code)
                    .orElseThrow(() ->new RuntimeException("Product code doesn't exist"));
            //name, price, qty(Partially update)
            if (!product.getName().isBlank())
                existingProduct.setName(product.getName());

            if(product.getPrice() != null)
                existingProduct.setPrice(product.getPrice());

            if(product.getQty() != null)
                existingProduct.setQty(product.getQty());

            int affectedRow = productDao.updateByCode(code, existingProduct);
            if(affectedRow < 1){
                System.out.println("Updated operation failed");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    //findAll
    @Override
    public List<Product> findAll() {
        try{
            return productDao.findAll();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

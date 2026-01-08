package istad;

import istad.config.DbConfig;
import istad.model.Product;
import istad.service.ProductService;
import istad.service.ProductServiceImpl;
import istad.util.InputUtil;
import istad.util.ViewUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class jdbcProgram {
    public static void main(String[] args) {
        //This is for testing
//        DbConfig.init();
//        Connection con1 = DbConfig.getInstance();
//
//        DbConfig.init();
//        Connection con2 = DbConfig.getInstance();
//
//        DbConfig.init();
//        Connection con3 = DbConfig.getInstance();
//
//
//        System.out.println(con1);
//        System.out.println(con2);
//        System.out.println(con3);


      //This for connect to database
      //Init connection
      DbConfig.init();
      //Init Service object
      ProductService productService = new ProductServiceImpl();


      do {
          ViewUtil.printMenu();
          int option = InputUtil.getInteger("Enter menu: ");
          switch(option){
              case 0 -> System.out.println("Exit");
              case 1 -> {
                  try{
                      List<Product> productList = productService.findAll();
                      ViewUtil.printProductList(productList);
                  }catch (RuntimeException e){
                      ViewUtil.printHeader(e.getMessage());
                  }
              }
              case 2 -> System.out.println("Search");
              case 3 -> {
                  String code = InputUtil.getText("Enter code: ");
                  String name = InputUtil.getText("Enter name: ");
                  BigDecimal price = InputUtil.getMoney("Enter price: ");
                  Integer qty = InputUtil.getInteger("Enter qty: ");

                  Product product = new Product(code, name, price, qty, false);

                  try{
                      productService.save(product);
                      ViewUtil.printHeader("Product save successfully");
                  }catch (RuntimeException e){
                      ViewUtil.printHeader(e.getMessage());
                  }
              }
              case 4 -> {
                  ViewUtil.printHeader("Update product by code: ");
                  String code = InputUtil.getText("Enter code: ");
                  System.out.println("========UPDATE NEW VALUES========");
                  String name = InputUtil.getText("Enter name: ");
                  BigDecimal price = InputUtil.getMoney("Enter price: ");
                  Integer qty = InputUtil.getInteger("Enter qty: ");

                  Product product = new Product();
                  product.setName(name);
                  product.setPrice(price);
                  product.setQty(qty);

                  try{
                      productService.updateByCode(code, product);
                      ViewUtil.printHeader("Product update successfully");
                  }catch (RuntimeException e){
                      ViewUtil.printHeader(e.getMessage());
                  }
              }

              case 5 -> {
                  String delete = InputUtil.getText("Enter Product Code : ");
                  try{
                    productService.deleteByCode(delete);
                  }catch (RuntimeException e){
                      ViewUtil.printHeader(e.getMessage());
                  }
              }
              default -> System.out.println("Invalid menu..!");
          }
      }while (true);

    }
}

package com.product.springdemo.DAO;



import com.product.springdemo.model.Product;
import com.product.springdemo.model.ProductRequest;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    String GET_ALL_PRODUCTS = "select * from product";
    String GET_PRODUCT_BY_ID = "select * from product where id = ?";
    String CREATE_NEW_PRODUCT = "insert into product (name, price, amount) values (?, ?, ?)";
    String UPDATE_PRODUCT = "update product set name = ?, price = ?, amount = ? where id = ?";
    String DELETE_PRODUCT = "delete from product where id = ?";

    List<Product> getAllProducts() throws SQLException;

    Product  getProductById(final int id);

    Product createProduct(final ProductRequest product);

    Product updateProduct(final Product product);

    boolean deleteProduct(final int id);
}

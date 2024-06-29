package com.product.springdemo.Service;

import com.product.springdemo.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws SQLException;

    Product  getProductById(final int id);

    Product createProduct(final Product product);

    Product updateProduct(final Product product);

    boolean deleteProduct(final int id);
}

package com.product.springdemo.Service.impl;

import com.product.springdemo.DAO.ProductDAO;
import com.product.springdemo.Service.ProductService;
import com.product.springdemo.model.Product;
import com.product.springdemo.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public Product createProduct(ProductRequest product) {
        return productDAO.createProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }
}

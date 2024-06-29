package com.product.springdemo.DAO.Impl;

import com.product.springdemo.DAO.ProductDAO;
import com.product.springdemo.UtilsForDB.DBUtils;
import com.product.springdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductDAOimpl implements ProductDAO {
    @Autowired
    private DBUtils dBUtils;

    @Override
    public List<Product> getAllProducts() {

        final Connection conn = dBUtils.getConnection();
        final List<Product> products = new ArrayList<>();
        try {
            final PreparedStatement ps = conn.prepareStatement(GET_ALL_PRODUCTS);

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final long id = rs.getLong("id");
                final String name = rs.getString("name");
                final double price = rs.getDouble("price");
                final int amount = rs.getInt("amount");

                final Product product = new Product((int) id, name, price, amount);
                products.add(product);

            }
            ps.close();
        } catch (SQLException ex) {
            throw new RuntimeException();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        final Connection conn = dBUtils.getConnection();
        final Product p = new Product();
        try {
            final PreparedStatement ps = conn.prepareStatement(GET_PRODUCT_BY_ID);
            ps.setInt(1, id);

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final String name = rs.getString("name");
                final double price = rs.getDouble("price");
                final int amount = rs.getInt("amount");

                p.setId(id);
                p.setName(name);
                p.setPrice(price);
                p.setAmount(amount);
            }
            ps.close();
        } catch (SQLException ex) {
            throw new RuntimeException();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return p;
    }

    @Override
    public Product createProduct(Product product) {
        final Connection conn = dBUtils.getConnection();
        final Product p = new Product();

        final PreparedStatement ps;
        final ResultSet rs;
        try {
            ps = conn.prepareStatement(CREATE_NEW_PRODUCT);

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getAmount());

            ps.executeUpdate();

            rs = ps.executeQuery();

            while (rs.next()) {
                final int id = rs.getInt("id");
                final String name = rs.getString("name");
                final double price = rs.getDouble("price");
                final int amount = rs.getInt("amount");

                p.setName(name);
                p.setPrice(price);
                p.setAmount(amount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        return p;

    }

    @Override
    public Product updateProduct(Product product) {

        final Connection conn = dBUtils.getConnection();
        final Product p = new Product();

        final PreparedStatement ps;
        final ResultSet rs;
        try {
            ps = conn.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getAmount());
            ps.setInt(4, product.getId());
            ps.executeUpdate();

            rs = ps.executeQuery();

            while (rs.next()) {
                  final int id = rs.getInt("id");
                final String name = rs.getString("name");
                final double price = rs.getDouble("price");
                final int amount = rs.getInt("amount");

                p.setName(name);
                p.setPrice(price);
                p.setAmount(amount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return p;
    }

    @Override
    public boolean deleteProduct(int id) {
        final Connection conn = dBUtils.getConnection();
        try {
            final PreparedStatement ps = conn.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return true;
    }

}

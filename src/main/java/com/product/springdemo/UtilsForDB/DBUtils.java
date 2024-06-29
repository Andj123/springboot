package com.product.springdemo.UtilsForDB;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



@Service
public class DBUtils {
    @Value("${product.url}")
    private String url;
    @Value("${product.username}")
    private String userName;
    @Value("${product.password}")
    private String password;
    public Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}

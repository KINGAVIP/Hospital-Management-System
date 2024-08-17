package com.hsbc.hospitalmanagement.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConManager {

    private static Properties properties = new Properties();
    private static FileInputStream fileInputStream;
    public static Connection getConnection() {

        try {
            fileInputStream = new FileInputStream("src/main/resources/db-config.properties");
            properties.load(fileInputStream);
            return DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.user"),
                    properties.getProperty("db.password"));

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

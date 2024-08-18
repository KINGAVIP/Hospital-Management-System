package com.hsbc.hospitalmanagement.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConManager {

    private static final String PROPERTIES_FILE = "db-config.properties";

    public static Connection getConnection() {
        Properties properties = new Properties();

        try (InputStream inputStream = ConManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (inputStream == null) {
                throw new RuntimeException("Property file '" + PROPERTIES_FILE + "' not found in the classpath. Check if it is placed in 'src/main/resources' and included in the build.");
            }
            properties.load(inputStream);
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.passwordAvi");

            if (dbUrl == null || dbUser == null || dbPassword == null) {
                throw new RuntimeException("Database connection properties are missing in the properties file.");
            }

            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection error", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file", e);
        }
    }
}

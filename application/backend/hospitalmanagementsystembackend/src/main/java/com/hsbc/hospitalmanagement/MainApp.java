package com.hsbc.hospitalmanagement;

import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {

    public static void main(String[] args) {
        Connection conn = ConManager.getConnection();
        try {
            System.out.println(conn.getCatalog() + conn.getMetaData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

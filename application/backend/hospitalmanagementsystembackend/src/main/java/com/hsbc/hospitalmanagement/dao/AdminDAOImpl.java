package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.domain.Admin;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    // SQL Queries
    private static final String INSERT_ADMIN = "INSERT INTO admins (id, name, phone_number, address, username, password) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ADMIN_BY_ID = "SELECT * FROM admins WHERE id = ?";
    private static final String SELECT_ALL_ADMINS = "SELECT * FROM admins";
    private static final String UPDATE_ADMIN = "UPDATE admins SET name = ?, phone_number = ?, address = ?, username = ?, password = ? WHERE id = ?";
    private static final String DELETE_ADMIN = "DELETE FROM admins WHERE id = ?";

    @Override
    public void addAdmin(Admin admin) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_ADMIN)) {
            ps.setString(1, admin.getId());
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getPhoneNumber());
            ps.setString(4, admin.getAddress());
            ps.setString(5, admin.getUsername());
            ps.setString(6, admin.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding admin", e);
        }
    }

    @Override
    public Admin getAdminById(String id) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ADMIN_BY_ID)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving admin by ID", e);
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        try (Connection connection = ConManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ADMINS)) {
            while (rs.next()) {
                admins.add(new Admin(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all admins", e);
        }
        return admins;
    }

    @Override
    public void updateAdmin(Admin admin) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_ADMIN)) {
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getPhoneNumber());
            ps.setString(3, admin.getAddress());
            ps.setString(4, admin.getUsername());
            ps.setString(5, admin.getPassword());
            ps.setString(6, admin.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating admin", e);
        }
    }

    @Override
    public void deleteAdmin(String id) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_ADMIN)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting admin", e);
        }
    }
}

package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.domain.Test;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAOImpl implements TestDAO {

    // SQL Queries
    private static final String INSERT_TEST = "INSERT INTO tests (test_id, name, price, description) VALUES (?, ?, ?, ?)";
    private static final String SELECT_TEST_BY_ID = "SELECT * FROM tests WHERE test_id = ?";
    private static final String SELECT_ALL_TESTS = "SELECT * FROM tests";
    private static final String UPDATE_TEST = "UPDATE tests SET name = ?, price = ?, description = ? WHERE test_id = ?";
    private static final String DELETE_TEST = "DELETE FROM tests WHERE test_id = ?";

    @Override
    public void addTest(Test test) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_TEST)) {
            ps.setString(1, test.getTestId());
            ps.setString(2, test.getName());
            ps.setString(3, test.getPrice());
            ps.setString(4, test.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding test", e);
        }
    }

    @Override
    public Test getTestById(String testId) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_TEST_BY_ID)) {
            ps.setString(1, testId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Test(
                        rs.getString("name"),
                        rs.getString("test_id"),
                        rs.getString("price"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving test by ID", e);
        }
        return null;
    }

    @Override
    public List<Test> getAllTests() {
        List<Test> tests = new ArrayList<>();
        try (Connection connection = ConManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_TESTS)) {
            while (rs.next()) {
                tests.add(new Test(
                        rs.getString("name"),
                        rs.getString("test_id"),
                        rs.getString("price"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all tests", e);
        }
        return tests;
    }

    @Override
    public void updateTest(Test test) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_TEST)) {
            ps.setString(1, test.getName());
            ps.setString(2, test.getPrice());
            ps.setString(3, test.getDescription());
            ps.setString(4, test.getTestId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating test", e);
        }
    }

    @Override
    public void deleteTest(String testId) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_TEST)) {
            ps.setString(1, testId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting test", e);
        }
    }
}

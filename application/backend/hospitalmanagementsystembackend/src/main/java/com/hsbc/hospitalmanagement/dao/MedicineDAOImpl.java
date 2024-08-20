package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.domain.Medicine;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAOImpl implements MedicineDAO {

    // SQL Queries
    private static final String INSERT_MEDICINE = "INSERT INTO medicines (medicine_id, name, price, description) VALUES (?, ?, ?, ?)";
    private static final String SELECT_MEDICINE_BY_ID = "SELECT * FROM medicines WHERE medicine_id = ?";
    private static final String SELECT_ALL_MEDICINES = "SELECT * FROM medicines";
    private static final String UPDATE_MEDICINE = "UPDATE medicines SET name = ?, price = ?, description = ? WHERE medicine_id = ?";
    private static final String DELETE_MEDICINE = "DELETE FROM medicines WHERE medicine_id = ?";

    @Override
    public void addMedicine(Medicine medicine) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_MEDICINE)) {
            ps.setString(1, medicine.getMedicineId());
            ps.setString(2, medicine.getName());
            ps.setString(3, medicine.getPrice());
            ps.setString(4, medicine.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding medicine", e);
        }
    }

    @Override
    public Medicine getMedicineById(String medicineId) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_MEDICINE_BY_ID)) {
            ps.setString(1, medicineId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Medicine(
                        rs.getString("name"),
                        rs.getString("medicine_id"),
                        rs.getString("price"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving medicine by ID", e);
        }
        return null;
    }

    @Override
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_MEDICINES)) {
            while (rs.next()) {
                medicines.add(new Medicine(
                        rs.getString("name"),
                        rs.getString("medicine_id"),
                        rs.getString("price"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all medicines", e);
        }
        return medicines;
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_MEDICINE)) {
            ps.setString(1, medicine.getName());
            ps.setString(2, medicine.getPrice());
            ps.setString(3, medicine.getDescription());
            ps.setString(4, medicine.getMedicineId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating medicine", e);
        }
    }

    @Override
    public void deleteMedicine(String medicineId) {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_MEDICINE)) {
            ps.setString(1, medicineId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting medicine", e);
        }
    }
}

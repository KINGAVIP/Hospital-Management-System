package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Medicine;

import java.util.List;

public interface MedicineDAO {
    public void addMedicine(Medicine medicine);
    public Medicine getMedicineById(String medicineId);
    List<Medicine> getAllMedicines();
    void updateMedicine(Medicine medicine);
    void deleteMedicine(String medicineId);
}

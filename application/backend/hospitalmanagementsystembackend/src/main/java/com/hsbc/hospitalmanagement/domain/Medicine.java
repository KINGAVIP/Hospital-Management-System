package com.hsbc.hospitalmanagement.domain;

import java.util.Objects;

public class Medicine {
    private String name;
    private String medicineId;
    private String price;
    private String description;

    public Medicine(String name, String medicineId, String price, String description) {
        this.name = name;
        this.medicineId = medicineId;
        this.price = price;
        this.description = description;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(medicineId, medicine.medicineId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(medicineId);
    }
}

package com.hsbc.hospitalmanagement.domain;

import java.util.Objects;

public class Test {
    private String name;
    private String testId;
    private String price;
    private String description;

    public Test(String name, String testId, String price, String description) {
        this.name = name;
        this.testId = testId;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
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
        Test test = (Test) o;
        return Objects.equals(testId, test.testId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(testId);
    }
}

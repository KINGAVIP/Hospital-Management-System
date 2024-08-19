package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.domain.Test;

import java.util.List;

public interface TestDAO {

    void addTest(Test test);
    Test getTestById(String testId);
    List<Test> getAllTests();
    void updateTest(Test test);
    void deleteTest(String testId);
}

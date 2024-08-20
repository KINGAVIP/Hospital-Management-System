package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    User getUserById(String id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(String id);
}

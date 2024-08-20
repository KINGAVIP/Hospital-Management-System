package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.dao.UserDAO;
import com.hsbc.hospitalmanagement.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> existingUser = users.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst();
        existingUser.ifPresent(u -> {
            u.setName(user.getName());
            u.setPhoneNumber(user.getPhoneNumber());
            u.setAddress(user.getAddress());
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
        });
    }

    @Override
    public User getUserById(String id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public void deleteUser(String id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}

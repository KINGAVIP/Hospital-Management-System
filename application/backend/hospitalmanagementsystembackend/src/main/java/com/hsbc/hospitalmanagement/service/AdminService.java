package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Admin;
import com.hsbc.hospitalmanagement.exception.ProfileAlreadyExistsException;
import com.hsbc.hospitalmanagement.exception.ProfileNotFoundException;

import java.util.List;

public interface AdminService {
    void registerAdmin(Admin admin) throws ProfileAlreadyExistsException;
    Admin getAdminById(String id) throws ProfileNotFoundException;
    List<Admin> getAllAdmins();
    void updateAdmin(Admin admin) throws ProfileNotFoundException;
    void deleteAdmin(String id) throws ProfileNotFoundException;
}

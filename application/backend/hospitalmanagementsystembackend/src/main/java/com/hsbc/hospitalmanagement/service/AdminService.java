package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Admin;
import java.util.List;

public interface AdminService {
    void registerAdmin(Admin admin);
    Admin getAdminById(String id);
    List<Admin> getAllAdmins();
    void updateAdmin(Admin admin);
    void deleteAdmin(String id);
}

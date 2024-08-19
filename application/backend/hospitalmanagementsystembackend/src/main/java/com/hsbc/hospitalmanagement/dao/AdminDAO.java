package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.domain.Admin;

import java.util.List;

public interface AdminDAO {

    void addAdmin(Admin admin);
    Admin getAdminById(String id);
    List<Admin> getAllAdmins();
    void updateAdmin(Admin admin);
    void deleteAdmin(String id);
}

package com.cbb.service;

import com.cbb.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(String username, String password);
    public List<Admin> showAllAdmin();
    public int removeAdmin(String username);
    public int modifyAdmin(Admin admin);
    public Admin showAdmin(String username);
}

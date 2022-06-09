package com.cbb.service;

import com.cbb.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(String username, String password);
    public List<Admin> showAllAdmin();
}

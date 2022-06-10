package com.cbb.service.impl;

import com.cbb.dao.AdminDao;
import com.cbb.dao.impl.AdminDaoImpl;
import com.cbb.entity.Admin;
import com.cbb.service.AdminService;
import com.cbb.utils.DbUtils;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(String username, String password) {
        Admin result = null;
        try {
            DbUtils.begin();
            Admin admin = adminDao.select(username);
            if(admin != null){
                if(admin.getPassword().equals(password)){
                    result = admin;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Admin> showAllAdmin() {
        List<Admin> admins = null;
        try{
            DbUtils.begin();
            admins = adminDao.selectAll();
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public int removeAdmin(String username) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.delete(username);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyAdmin(Admin admin) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.update(admin);
            DbUtils.commit();
            return result;
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Admin showAdmin(String username) {
        Admin admin = null;
        try {
            DbUtils.begin();
            admin = adminDao.select(username);
            DbUtils.commit();
            return admin;
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return null;
    }
}

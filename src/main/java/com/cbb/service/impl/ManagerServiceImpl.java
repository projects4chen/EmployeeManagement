package com.cbb.service.impl;

import com.cbb.dao.ManagerDao;
import com.cbb.dao.impl.ManagerDaoImpl;
import com.cbb.entity.Manager;
import com.cbb.service.ManagerService;
import com.cbb.utils.DbUtils;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public Manager login(String username, String password) {
        Manager manager = null;
        try {
            DbUtils.begin();
            Manager temp = managerDao.select(username);
            if(temp != null){
                if(temp.getPassword().equals(password)){
                    manager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return manager;
    }
}

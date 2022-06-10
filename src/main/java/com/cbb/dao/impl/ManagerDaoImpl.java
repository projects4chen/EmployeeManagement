package com.cbb.dao.impl;

import com.cbb.dao.ManagerDao;
import com.cbb.entity.Manager;
import com.cbb.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public Manager select(String username) {
        try {
            Manager manager = queryRunner.query(DbUtils.getConnection(), "select * from manager where username=?", new BeanHandler<Manager>(Manager.class), username);
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

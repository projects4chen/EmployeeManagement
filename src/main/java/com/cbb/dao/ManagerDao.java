package com.cbb.dao;

import com.cbb.entity.Manager;

public interface ManagerDao {
    public Manager select(String username);
}

package com.cbb.servlet.controller;

import com.cbb.entity.Admin;
import com.cbb.service.AdminService;
import com.cbb.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/safe/showadmin")
public class ShowAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取username
        String username = (String) req.getParameter("username");
        // 2. 获取完整的内容
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.showAdmin(username);
        // 3. 存入request
        req.setAttribute("admin", admin);
        // 4. 展示
        req.getRequestDispatcher("/safe/modifyjsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.cbb.servlet.controller;

import com.cbb.entity.Admin;
import com.cbb.entity.Manager;
import com.cbb.service.AdminService;
import com.cbb.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/safe/showallcontroller")
public class ShowAllAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用业务逻辑功能
        AdminService adminService = new AdminServiceImpl();
        List<Admin> adminList = adminService.showAllAdmin();

        // request作用域存储
        req.setAttribute("admins", adminList);
        // 转发跳转到显示结果servlet
        req.getRequestDispatcher("/safe/showalladminjsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

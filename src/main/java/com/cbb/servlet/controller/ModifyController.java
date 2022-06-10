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

@WebServlet(value = "/safe/modify")
public class ModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 收参
        String username = (String)req.getParameter("username");
        String password = (String)req.getParameter("password");
        String phone = (String)req.getParameter("phone");
        String address = (String)req.getParameter("address");
        Admin admin = new Admin(username, password, phone, address);
        System.out.println("amdin: " + admin);
        // 2. 根据username修改记录
        AdminService adminService = new AdminServiceImpl();
        int result = adminService.modifyAdmin(admin);
        // 3. 显示
        resp.sendRedirect("/safe/showallcontroller");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

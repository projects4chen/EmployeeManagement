package com.cbb.servlet.controller;

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

@WebServlet(value = "/safe/remove")
public class RemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取用户名
        String username = (String) req.getParameter("username");
        // 2. 删除
        AdminService adminService = new AdminServiceImpl();
        int result = adminService.removeAdmin(username);
        // 3. 重新查询
        resp.sendRedirect("/safe/showallcontroller");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

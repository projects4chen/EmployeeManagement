package com.cbb.servlet.controller;

import com.cbb.entity.Admin;
import com.cbb.entity.Manager;
import com.cbb.service.AdminService;
import com.cbb.service.ManagerService;
import com.cbb.service.impl.AdminServiceImpl;
import com.cbb.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 处理乱码, Filter已处理

        // 2. 收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");

        // 3. 验证验证码
        HttpSession session = req.getSession();
        String codes = (String)session.getAttribute("codes");
        if(!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)){
            // 4. 管理员 or 普通员工
            // 判断是否为管理员
            ManagerService managerService = new ManagerServiceImpl();
            Manager mgr = managerService.login(username, password);
            if(mgr != null){
                // 为管理员，将其信息存储在session里
                session.setAttribute("mgr", mgr);
                // 跳转
                resp.sendRedirect("/safe/showallcontroller");
            }else{
                // 非管理员，判断是否为员工
                AdminService adminService = new AdminServiceImpl();
                Admin admin = adminService.login(username, password);
                if(admin != null){
                    // 为员工，将其信息存储在session中
                    session.setAttribute("admin", admin);
                    // 跳转
                    req.getRequestDispatcher("/safe/showhellojsp").forward(req, resp);
                }
                // 非员工，重新登录
                resp.sendRedirect("/login.html");
            }
        }else{
            // 验证码错误，重新登录
            resp.sendRedirect("/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

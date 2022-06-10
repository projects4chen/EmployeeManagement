package com.cbb.servlet.controller;

import com.cbb.entity.Manager;
import com.cbb.service.ManagerService;
import com.cbb.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginMgrController", value = "/loginMgr")
public class LoginMgrController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 处理乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        // 2. 收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");

        // 验证验证码
        HttpSession session = req.getSession();
        String codes = (String)session.getAttribute("codes");
        if(!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)){
            // 3. 调用业务方法
            ManagerService managerService = new ManagerServiceImpl();
            Manager mgr = managerService.login(username, password);
            // 4. 处理结果，流程跳转
            if(mgr != null){
                // 登录成功
                // 将管理员信息存储在session里
                session.setAttribute("mgr", mgr);
                // 跳转
                resp.sendRedirect("/showallcontroller");
            }else{
                // 登录失败
                resp.sendRedirect("/loginMgr.html");
            }
        }else{
            resp.sendRedirect("/loginMgr.html");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

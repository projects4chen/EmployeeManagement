package com.cbb.servlet.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/createCode")
public class CreateCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 创建验证码图片
        ValidateCode code = new ValidateCode(200, 30, 4, 20);
        // 2. 放进session
        String codes = code.getCode();
        HttpSession session = req.getSession();
        session.setAttribute("codes", codes);
        // 3. 验证码图片响应给客户端
        code.write(resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.cbb.servlet.jsp;

import com.cbb.entity.Admin;
import com.cbb.entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/safe/modifyjsp")
public class ModifyJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 处理乱码，已在Filter处理

        // 2. 获取Admin
        Admin admin = (Admin)req.getAttribute("admin");
        // 3. 编写返回的内容
        PrintWriter printWriter = resp.getWriter();
        if(admin != null) {
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("<title>修改员工信息</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<form action='/safe/modify' method='post'>");
            printWriter.println("   用户名：<input type='text' name='username' value='" + admin.getUsername() + "' readonly/><br/>");
            printWriter.println("   密码：<input type='text' name='password' value='" + admin.getPassword() + "'/><br/>");
            printWriter.println("   手机号：<input type='text' name='phone' value='" + admin.getPhone() + "'/><br/>");
            printWriter.println("   住址：<input type='text' name='address' value='" + admin.getAddress() + "'/><br/>");
            printWriter.println("   <input type='submit' value='修改'>");
            printWriter.println("</form>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

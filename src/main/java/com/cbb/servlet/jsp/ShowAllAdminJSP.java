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

@WebServlet(value = "/safe/showalladminjsp")
public class ShowAllAdminJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Manager mgr = (Manager) session.getAttribute("mgr");
        List<Admin> adminList = (List)req.getAttribute("admins");

        PrintWriter printWriter = resp.getWriter();
        if(adminList != null){
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("<title>显示所有</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h1>欢迎您：" + mgr.getUsername() + "</h1>");
            printWriter.println("<table border='1'>");
            printWriter.println("   <tr>");
            printWriter.println("       <td>username</td>");
            printWriter.println("       <td>password</td>");
            printWriter.println("       <td>phone</td>");
            printWriter.println("       <td>address</td>");
            printWriter.println("       <td colspan='2'>options</td>");
            printWriter.println("   </tr>");
            for(Admin admin : adminList){
                printWriter.println("   <tr>");
                printWriter.println("       <td>" + admin.getUsername() + "</td>");
                printWriter.println("       <td>" + admin.getPassword() + "</td>");
                printWriter.println("       <td>" + admin.getPhone() + "</td>");
                printWriter.println("       <td>" + admin.getAddress() + "</td>");
                printWriter.println("       <td><a href='" + req.getContextPath() + "/safe/showadmin?username=" + admin.getUsername() + "'>修改</a></td>");
                printWriter.println("       <td><a href='" + req.getContextPath() + "/safe/remove?username=" + admin.getUsername() + "'>删除</a></td>");
                printWriter.println("   </tr>");
            }
            printWriter.println("</table>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }else{
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("<title>显示所有</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h3>当前没有用户</h3>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

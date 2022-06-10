package com.cbb.servlet.filter;

import com.cbb.entity.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/safe/*")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        Manager mgr = (Manager)session.getAttribute("mgr");
        if(mgr != null){
            // 管理员，放行
            filterChain.doFilter(request, response);
        }else{
            // 非管理员，跳转到登录页面
            response.sendRedirect("/login.html");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

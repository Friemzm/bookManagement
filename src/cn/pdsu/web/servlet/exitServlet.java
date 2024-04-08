package cn.pdsu.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/exitServlet")
public class exitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        销毁session中的用户名
        request.getSession().invalidate();
        //重定向，跳转页面
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}

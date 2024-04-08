package cn.pdsu.web.servlet;

import cn.pdsu.bean.BookUser;
import cn.pdsu.service.Impl.bookUserServiceImpl;
import cn.pdsu.service.Impl.userServiceImpl;
import cn.pdsu.service.bookUserService;
import cn.pdsu.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
    bookUserService service1 = new bookUserServiceImpl();
    userService service2 = new userServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取到用户名
        String username = request.getParameter("username");
//        首先根据用户名删除书籍信息
        service1.emptyCar(username);
        service2.deleteUser(username);

//        销毁session中的用户名
        request.getSession().invalidate();
        //重定向，跳转页面
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}

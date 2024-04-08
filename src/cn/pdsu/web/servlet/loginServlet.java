package cn.pdsu.web.servlet;

import cn.pdsu.bean.Controller;
import cn.pdsu.bean.User;
import cn.pdsu.service.Impl.controllerServiceImpl;
import cn.pdsu.service.Impl.userServiceImpl;
import cn.pdsu.service.controllerService;
import cn.pdsu.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/userLoginServlet")
public class loginServlet extends HttpServlet {
    //获取到service对象
    userService service1 = new userServiceImpl();
    controllerService service2 = new controllerServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //       获取到请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        获取到管理员信息
        Controller controller = service2.seekController();

//        首先查询用户名是否存在
        User userByUsername = service1.findUserByUsername(username);
        if (userByUsername == null && !username.equals(controller.getContname())){
//            重定向到到注册页面
            response.sendRedirect(request.getContextPath()+"/register.jsp");
        }else{
//            管理员
            if (username.equals(controller.getContname()) && password.equals(controller.getPassword())){
//            重定向到管理员页面
                response.sendRedirect(request.getContextPath()+"/contAllBookServlet");
            }else{ //普通用户
                HttpSession session = request.getSession();
                String username1 = "欢迎你"+username;
                if (service1.userLogin(username,password)){
//            将用户名存入session域中
                    session.setAttribute("loginUserNameIndex",username1);
                    session.setAttribute("loginUserName",username);
//            用户名和密码都正确,重定向到首页
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                }else{
//            用户名或密码错误
//            将错误提示信息存储到request域中
                    String loginErr = "密码错误";
                    request.setAttribute("loginErr",loginErr);
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
            }
        }
    }
}

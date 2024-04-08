package cn.pdsu.web.servlet;

import cn.pdsu.bean.User;
import cn.pdsu.service.Impl.userServiceImpl;
import cn.pdsu.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userRegisterServlet")
public class userRegisterServlet extends HttpServlet {

//获取到service对象
    userService service = new userServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       获取到请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");

//        创建User对象
        User user = new User(username,password,gender,email,telephone);
//      添加用户
        if (service.findUserByUsername(user.getUsername()) == null){
//            添加成功
            service.addUser(user);
//      重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
//      用户名存在，注册失败,存储提示信息，转发页面
            String registerErr = "该用户已经存在";
            request.setAttribute("registerErr",registerErr);
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
}

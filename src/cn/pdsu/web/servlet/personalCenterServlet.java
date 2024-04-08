package cn.pdsu.web.servlet;

import cn.pdsu.bean.User;
import cn.pdsu.service.Impl.userServiceImpl;
import cn.pdsu.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//个人中心
@WebServlet("/personalCenterServlet")
public class personalCenterServlet extends HttpServlet {
    userService service = new userServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取到当前登录的用户名
        HttpSession session = request.getSession();
        String loginUserName = String.valueOf(session.getAttribute("loginUserName"));
//        根据用户名查询用户信息
        User user = service.findUserByUsername(loginUserName);
//        将用户信息存入request域中
        request.setAttribute("personalCenterUser",user);

        //       获取到请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");

//        创建User对象
        User user2 = new User(username, password, gender, email, telephone);
        if (user2.getUsername() != null){
//            更改用户信息
            service.updateUser(user2);
//            更新request域中的用户信息
            request.setAttribute("personalCenterUser",user2);
        }

//        页面请求转发到personalCenter.jsp
        request.getRequestDispatcher("/personalCenter.jsp").forward(request,response);
    }
}

package cn.pdsu.web.servlet;

import cn.pdsu.bean.BookUser;
import cn.pdsu.service.Impl.bookUserServiceImpl;
import cn.pdsu.service.bookUserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/shopCarListServlet")
public class shopCarListServlet extends HttpServlet {
//  创建service层对象
    bookUserService service = new bookUserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取到当前登录的用户名
        HttpSession session = request.getSession();
        String loginUserName = String.valueOf(session.getAttribute("loginUserName"));
        //根据用户名获取到购物车内所有商品信息
        List<BookUser> allGoods = service.findAllGoods(loginUserName);
        //        将书籍列表信息存储到request域中
        request.setAttribute("goods",allGoods);
        request.getRequestDispatcher("/shopCarList.jsp").forward(request,response);
    }
}

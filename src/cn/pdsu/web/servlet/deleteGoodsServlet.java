package cn.pdsu.web.servlet;

import cn.pdsu.bean.BookUser;
import cn.pdsu.service.Impl.bookUserServiceImpl;
import cn.pdsu.service.bookUserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteGoodsServlet")
public class deleteGoodsServlet extends HttpServlet {
//  创建service层对象
    bookUserService service = new bookUserServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取到书籍名称参数和当前登录的用户名
        String name = request.getParameter("name");
        String loginUserName = request.getParameter("loginUserName");
//         根据书籍名称和用户名查询商品信息
        BookUser bookUser = service.findGoods(name, loginUserName);
//        根据书籍名称和用户名查询当前书籍数量
        int number = service.bookNumber(name, loginUserName);
        if (number != 0){
//            当前书籍数量不为空，减少书籍数量
            number--;
            service.reduceBookNumber(bookUser,number,loginUserName);
//            重定向到购物车
            response.sendRedirect(request.getContextPath()+"/shopCarListServlet");
        }
        if(number == 0){
//            为空时删除商品
            service.deleteBook(name,loginUserName);
        }
    }
}

package cn.pdsu.web.servlet;

import cn.pdsu.bean.Book;
import cn.pdsu.bean.BookUser;
import cn.pdsu.service.Impl.bookServiceImpl;
import cn.pdsu.service.Impl.bookUserServiceImpl;
import cn.pdsu.service.bookService;
import cn.pdsu.service.bookUserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shopCarServlet")
public class shopCarServlet extends HttpServlet {
//    创建service层对象
    bookService service1 = new bookServiceImpl();
    bookUserService service2 = new bookUserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取到书籍名称参数以及当前登录的用户名
        String bookName = request.getParameter("name");
        String userName = request.getParameter("loginUserName");
        if (userName == "" || userName == null){
//        当前未有用户登录但是却添加书籍，直接重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{

//        调用service层根据书籍名称进行查询书籍
            Book book = service1.seeKShopCarBook(bookName);
//        调用service层根据书籍和用户名查询书籍数量
            int number = service2.bookNumber(book.getName(), userName);

            if (number == 0){
                //将书籍信息和用户添加到book_user表中
                service2.addShopCar(book,number+1,userName);
            }else{
//                增加书籍数量
                number++;
                service2.addBookNumber(book,number,userName);
            }
//        请求转发到allBookServlet
            request.getRequestDispatcher("/allBookServlet").forward(request,response);
        }
    }
}

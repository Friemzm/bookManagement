package cn.pdsu.web.servlet;

import cn.pdsu.bean.Book;
import cn.pdsu.bean.BookUser;
import cn.pdsu.service.Impl.bookUserServiceImpl;
import cn.pdsu.service.bookUserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/seekBookCarServlet")
public class seekBookCarServlet extends HttpServlet {
//    创建service层对象
    bookUserService service = new bookUserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取到参数
        String bookName = request.getParameter("bookName");
        String classify = request.getParameter("classify");
//        获取到当前登录的用户名
        HttpSession session = request.getSession();
        String loginUserName = String.valueOf(session.getAttribute("loginUserName"));
        if ((bookName != null && bookName != "") || (classify != null&&classify != "")){
            List<BookUser> seekBooks = service.seekBookCar(bookName, classify,loginUserName);
//            向request域中存储查询到的书籍信息
            request.setAttribute("goods",seekBooks);
            request.getRequestDispatcher("/shopCarList.jsp").forward(request,response);
        }else{
//            向request域中存储提示信息
            String seekError = "查询失败";
            request.setAttribute("seekError",seekError);
        }
    }
}

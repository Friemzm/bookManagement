package cn.pdsu.web.servlet;

import cn.pdsu.bean.Book;
import cn.pdsu.service.Impl.bookServiceImpl;
import cn.pdsu.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/contSeekBookServlet")
public class contSeekBookServlet extends HttpServlet {
    //    创建service层对象
    bookService service = new bookServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取到参数
        String bookName = request.getParameter("bookName");
        String classify = request.getParameter("classify");
        if ((bookName != null && bookName != "") || (classify != null && classify != "")){
            List<Book> seekBooks = service.seekBook(bookName, classify);
            System.out.println(seekBooks);
//            向request域中存储查询到的书籍信息
            request.setAttribute("books",seekBooks);
            request.getRequestDispatcher("/controller.jsp").forward(request,response);
        }
    }
}

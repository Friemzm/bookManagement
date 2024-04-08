package cn.pdsu.web.servlet;

import cn.pdsu.bean.Book;
import cn.pdsu.service.Impl.bookServiceImpl;
import cn.pdsu.service.bookService;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/allBookServlet")
public class allBookServlet extends HttpServlet {
//  获取到Service对象
    bookService service = new bookServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> allBook = service.findAllBook();
//        将书籍列表信息存储到request域中
        request.setAttribute("books",allBook);
        request.getRequestDispatcher("/bookList.jsp").forward(request,response);
    }
}

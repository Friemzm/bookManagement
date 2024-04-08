package cn.pdsu.web.servlet;

import cn.pdsu.bean.Book;
import cn.pdsu.service.Impl.bookServiceImpl;
import cn.pdsu.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/contAddBookServlet")
public class contAddBookServlet extends HttpServlet {
    bookService service = new bookServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       获取到请求参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String classify = request.getParameter("classify");
        String descr = request.getParameter("descr");
        float price = Float.parseFloat((request.getParameter("price")));
        Book book = new Book(id,name,author,classify,descr,price);
//      根据书籍名查询书籍
        Book book1 = service.seeKShopCarBook(name);
        if (book1 == null){
            service.addBook(book);
//      重定向到管理员页面
            response.sendRedirect(request.getContextPath()+"/contAllBookServlet");
        }else{
            //     书籍存在，添加失败,存储提示信息，转发页面
            String addErr = "该书籍已经存在";
            request.setAttribute("addErr",addErr);
            request.getRequestDispatcher("/addBook.jsp").forward(request,response);
        }
    }
}

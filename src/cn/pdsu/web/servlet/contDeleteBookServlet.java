package cn.pdsu.web.servlet;

import cn.pdsu.service.Impl.controllerServiceImpl;
import cn.pdsu.service.controllerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/contDeleteBookServlet")
public class contDeleteBookServlet extends HttpServlet {
    controllerService service = new controllerServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取到书籍名称
        String bookName = request.getParameter("bookName");
        service.deleteBook(bookName);
//        重定向到controlAllBookServlet.java
        response.sendRedirect(request.getContextPath()+"/contAllBookServlet");
    }
}

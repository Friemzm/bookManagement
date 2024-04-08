package cn.pdsu.web.servlet;

import cn.pdsu.bean.Book;
import cn.pdsu.service.Impl.bookServiceImpl;
import cn.pdsu.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/seekBookServlet")
public class seekBookServlet extends HttpServlet {
//    创建service层对象
    bookService service = new bookServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取到参数

        String classify="";
        String bookName="";
        String classify1 = request.getParameter("classify1");
        String type = request.getParameter("type");
        String bookName1 = request.getParameter("bookName");
        System.out.println(bookName);
        if (type.equals("query")){
            classify=classify1;
            bookName=bookName1;
        }else if (type.equals("kh")){
            classify="科幻小说";
        }else if (type.equals("jdwx")){
            classify="经典文学";
        }else if (type.equals("shkx")){
            classify="社会科学";
        }else if (type.equals("jjx")){
            classify="经济学";
        }else if (type.equals("xl")){
            classify="心理学";
        }else if (type.equals("zx")){
            classify="哲学";
        }else if (type.equals("xdwx")){
            classify="现代文学";
        }else if (type.equals("xyj")){
            bookName="西游记";
        }else if (type.equals("hlm")){
            bookName="红楼梦";
        }else if (type.equals("sgyy")){
            bookName="三国演义";
        }else if (type.equals("shz")){
            bookName="水浒传";
        }else {
            classify="";
            bookName="";
        }


        if ((bookName != null && bookName != "") || (classify != null && classify != "")){

            List<Book> seekBooks = service.seekBook(bookName, classify);
//            向request域中存储查询到的书籍信息
            System.out.println("----->"+seekBooks);
            request.setAttribute("books",seekBooks);
            request.getRequestDispatcher("/bookList.jsp").forward(request,response);
        }else{
//            向request域中存储提示信息
            String seekError = "查询失败";
            request.setAttribute("seekError",seekError);
        }
    }
}

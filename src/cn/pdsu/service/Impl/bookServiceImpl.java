package cn.pdsu.service.Impl;

import cn.pdsu.bean.Book;
import cn.pdsu.dao.bookDao;
import cn.pdsu.dao.impl.bookDaoImpl;
import cn.pdsu.service.bookService;

import java.util.List;

public class bookServiceImpl implements bookService {
//   创建dao层对象
    private bookDao dao = new bookDaoImpl();
//    查询所有书籍
    public List<Book> findAllBook() {
        List<Book> books = dao.findAllBook();
        return books;
    }
//    根据条件进行查询
    public List<Book> seekBook(String bookName, String classify) {
        List<Book> books = dao.seekBook(bookName, classify);
        return books;
    }

    //    根据主键书籍名称进行查询
    public Book seeKShopCarBook(String bookName) {
        Book book = dao.seeKshopCarBook(bookName);
        return book;
    }

    //    添加书籍
    public void addBook(Book book) {
        dao.addBook(book);
    }
}

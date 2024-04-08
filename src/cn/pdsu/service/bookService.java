package cn.pdsu.service;

import cn.pdsu.bean.Book;

import java.util.List;

public interface bookService {
//    查询所有书籍
    public List<Book> findAllBook();
//    根据条件进行查询
    public List<Book> seekBook(String bookName,String classify);
//    根据主键书籍名称进行查询
    public Book seeKShopCarBook(String bookName);
//    添加书籍
    public void addBook(Book book);
}

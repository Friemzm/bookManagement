package cn.pdsu.dao;

import cn.pdsu.bean.Book;

import java.util.List;

public interface bookDao {
//    查询所有书籍
    public List<Book> findAllBook();
//    根据条件进行查询书籍
    public List<Book> seekBook(String bookName,String classify);
//    根据书籍名称进行查询
    public Book seeKshopCarBook(String bookName);
//    添加书籍
    public void addBook(Book book);
}

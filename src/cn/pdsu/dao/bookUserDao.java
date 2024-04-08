package cn.pdsu.dao;

import cn.pdsu.bean.Book;
import cn.pdsu.bean.BookUser;

import java.util.List;

public interface bookUserDao {
//    根书籍名称和用户名查询书籍数量
    public int bookNumber(String name, String username);
//    根据书籍对象和用户名添加
    public void addShopCar(Book book,int number,String username);
    //    增加书籍数量
    public void addBookNumber(Book book,int number,String username);
//    减少书籍数量
    public void reduceBookNumber(BookUser bookUser,int number,String username);
//    删除书籍
    public void deleteBook(String name,String username);
//    根据书籍名称和用户名查询书籍信息
    public BookUser findGoods(String name,String username);
//    查询购物车所有的书籍
    public List<BookUser> findAllGoods(String username);
//    根据条件进行查询
    public List<BookUser> seekBookCar(String bookName,String classify,String username);
//    根据用户名清空购物车
    public void emptyCar(String username);
}

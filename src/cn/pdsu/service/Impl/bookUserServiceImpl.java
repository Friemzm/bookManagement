package cn.pdsu.service.Impl;

import cn.pdsu.bean.Book;
import cn.pdsu.bean.BookUser;
import cn.pdsu.dao.bookUserDao;
import cn.pdsu.dao.impl.bookUserDaoImpl;
import cn.pdsu.service.bookUserService;

import java.util.List;

public class bookUserServiceImpl implements bookUserService {
    bookUserDao dao = new bookUserDaoImpl();
    //    根据书籍对象和用户名添加
    public void addShopCar(Book book,int number, String username) {
        dao.addShopCar(book,number,username);
    }

    //    根书籍名称和用户名查询书籍数量
    public int bookNumber(String name, String username) {
        int number = dao.bookNumber(name, username);
        return number;
    }
    //    增加书籍数量
    public void addBookNumber(Book book,int number,String username){
        dao.addBookNumber(book,number,username);
    }

    //    减少书籍数量
    public void reduceBookNumber(BookUser bookUser, int number, String username) {
        dao.reduceBookNumber(bookUser,number,username);
    }

// 删除书籍
    public void deleteBook(String name, String username) {
        dao.deleteBook(name,username);
    }

    //    根据书籍名称和用户名查询书籍信息
    public BookUser findGoods(String name, String username) {
        BookUser goods = dao.findGoods(name, username);
        return goods;
    }

    //    查询购物车所有的书籍
    public List<BookUser> findAllGoods(String username) {
        List<BookUser> allGoods = dao.findAllGoods(username);
        return allGoods;
    }

    //    根据条件进行查询
    public List<BookUser> seekBookCar(String bookName, String classify,String username) {
        List<BookUser> books = dao.seekBookCar(bookName, classify,username);
        return books;
    }

    //    根据用户名清空购物车
    public void emptyCar(String username) {
        dao.emptyCar(username);
    }

}

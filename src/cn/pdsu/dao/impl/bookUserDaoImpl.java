package cn.pdsu.dao.impl;

import cn.pdsu.bean.Book;
import cn.pdsu.bean.BookUser;
import cn.pdsu.dao.bookUserDao;
import cn.pdsu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class bookUserDaoImpl implements bookUserDao {
    //    创建jdbcTemplate对象
    public JdbcTemplate jdbcTemplate =new JdbcTemplate(JDBCUtils.getDataSource());
//    根书籍名称和用户名查询书籍数量
    public int bookNumber(String name, String username) {
        String sql = "select number from book_user where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (name != null){
            String bookName = '"' + name + '"';
            newsql.append(" and name = "+bookName);
        }
        if (username != "" && username != null){
            username = '"'+username+'"';
            newsql.append(" and username = "+username);
        }
        sql = newsql.toString();
        BookUser bookUser = null;
        try {
            bookUser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<BookUser>(BookUser.class));
            return bookUser.getNumber();
        } catch (DataAccessException e) {
            return 0;
        }
    }

    //    根据书籍对象和用户名添加
    public void addShopCar(Book book,int number,String username) {
        String sql = "insert into book_user values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getClassify(),
                book.getDescr(),
                book.getPrice(),
                number,
                username);
    }
    //    增加书籍数量
    public void addBookNumber(Book book,int number,String username){
        String sql = "update book_user set number = ? where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (book != null){
            String bookName = '"' + book.getName() + '"';
            newsql.append(" and name = "+bookName);
        }
        if (username != "" && username != null){
            username = '"'+username+'"';
            newsql.append(" and username = "+username);
        }
        sql = newsql.toString();
        jdbcTemplate.update(sql,number);
    }

    //    减少书籍数量
    public void reduceBookNumber(BookUser bookUser, int number, String username) {
        String sql = "update book_user set number = ? where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (bookUser != null){
            String bookName = '"' + bookUser.getName() + '"';
            newsql.append(" and name = "+bookName);
        }
        if (username != "" && username != null){
            username = '"'+username+'"';
            newsql.append(" and username = "+username);
        }
        sql = newsql.toString();
        jdbcTemplate.update(sql,number);
    }

    //    删除书籍
    public void deleteBook(String name, String username) {
        String sql = "delete from book_user where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (name != null){
            String bookName = '"' + name + '"';
            newsql.append(" and name = "+bookName);
        }
        if (username != "" && username != null){
            username = '"'+username+'"';
            newsql.append(" and username = "+username);
        }
        sql = newsql.toString();
        jdbcTemplate.update(sql);
    }

    //    根据书籍名称和用户名查询书籍信息
    public BookUser findGoods(String name, String username) {
        String sql = "select * from book_user where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (name != "" && name != null){
            name = '"'+name+'"';
            newsql.append(" and name = "+name);
        }
        if (username != "" && username != null){
            username = '"'+username+'"';
            newsql.append(" and username = "+username);
        }
        sql = newsql.toString();
        BookUser goods = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<BookUser>(BookUser.class));
        return goods;
    }


    //    查询购物车所有的书籍
    public List<BookUser> findAllGoods(String username) {
        String sql = "select * from book_user where username = ?";
        List<BookUser> allGoods = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BookUser>(BookUser.class),username);
        return allGoods;
    }

    //    根据条件进行查询
    public List<BookUser> seekBookCar(String bookName, String classify,String username) {
        String sql = "select * from book_user where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (bookName != "" && bookName != null){
            bookName = '"' + bookName + '"';
            newsql.append(" and name = "+bookName);
        }
        if (classify != "" && classify != null){
            classify = '"' + classify + '"';
            newsql.append(" and classify = "+classify);
        }
        if (username != "" && username != null){
            username = '"'+username+'"';
            newsql.append(" and username = "+username);
        }
        sql = newsql.toString();
        List<BookUser> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BookUser>(BookUser.class));
        return books;
    }

    //    根据用户名清空购物车
    public void emptyCar(String username) {
        String sql = "delete from book_user where username = ?";
        jdbcTemplate.update(sql,username);
    }
}

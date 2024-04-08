package cn.pdsu.dao.impl;

import cn.pdsu.bean.Book;
import cn.pdsu.dao.bookDao;
import cn.pdsu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class bookDaoImpl implements bookDao {
//    创建jdbcTemplate对象
    public JdbcTemplate jdbcTemplate =new JdbcTemplate(JDBCUtils.getDataSource());
//    查询所有书籍
    public List<Book> findAllBook() {
        String sql = "select * from book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }
//    根据条件进行查询书籍
    public List<Book> seekBook(String bookName, String classify) {
        String sql = "select * from book where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (bookName != "" && bookName != null){
            bookName = '"'+ bookName + '"';
            newsql.append(" and name = "+bookName);
        }
        if (classify != "" && classify != null){
            classify = '"' + classify + '"';
            newsql.append(" and classify = "+classify);
        }
        sql = newsql.toString();
        System.out.println(sql);
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

//      根据主键书籍名称进行查询
    public Book seeKshopCarBook(String bookName) {
        String sql = "select * from book where 1 = 1";
        StringBuffer newsql = new StringBuffer(sql);
        if (bookName != null && bookName != ""){
            bookName = '"' +bookName + '"';
            newsql.append(" and name = "+bookName);
        }
        sql = newsql.toString();
        Book book = null;
        try {
            book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class));
            return book;
        } catch (DataAccessException e) {
            return null;
        }
    }

    //    添加书籍
    public void addBook(Book book) {
        String sql = "insert into book values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, book.getId(), book.getName(), book.getAuthor(), book.getClassify(), book.getDescr(), book.getPrice());
    }
}

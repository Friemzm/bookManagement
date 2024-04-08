package cn.pdsu.dao.impl;

import cn.pdsu.bean.Controller;
import cn.pdsu.dao.controllerDao;
import cn.pdsu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class controllerDaoImpl implements controllerDao {
//    创建jdbcTemplate对象
    public JdbcTemplate jdbcTemplate =new JdbcTemplate(JDBCUtils.getDataSource());
    //    查询管理员信息
    public Controller seekController() {
        String sql = "select * from controller";
        Controller controller = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Controller>(Controller.class));
        return controller;
    }

    //    根据书籍名称删除书籍
    public void deleteBook(String bookName) {
        String sql1 = "delete from book where name = ?";
        String sql2 = "delete from book_user where name = ?";
        jdbcTemplate.update(sql1,bookName);
        jdbcTemplate.update(sql2,bookName);
    }
}

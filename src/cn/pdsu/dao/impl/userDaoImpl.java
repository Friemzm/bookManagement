package cn.pdsu.dao.impl;

import cn.pdsu.bean.User;
import cn.pdsu.dao.userDao;
import cn.pdsu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class userDaoImpl implements userDao {
    //    创建JDBCTemplate对象(Spring对JDBC进行封装)
    public JdbcTemplate jdbcTemplate =new JdbcTemplate(JDBCUtils.getDataSource());

//    查询用户
    public User findUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        User user1 = null;
        try {
            user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
        }
        return user1;
    }

//    添加用户
    public void addUser(User user) {
        String sql = "insert into user(username,password,gender,email,telephone) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(),
                user.getPassword(),
                user.getGender(),
                user.getEmail(),
                user.getTelephone());
    }

//    登陆验证
    public User userLogin(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {
        }
        return user;
    }

    //    更改用户信息
    public void updateUser(User user) {
        String sql = "update user set";
        String password,gender,email,telephone,username;
        StringBuffer newsql = new StringBuffer(sql);
        if (user.getPassword() != "" && user.getPassword() != null){
            password = '"'+user.getPassword()+'"';
            newsql.append(" password = "+password);
        }
        if (user.getGender() != "" && user.getGender() != null){
            gender = '"'+user.getGender()+'"';
            newsql.append(" , gender = "+gender);
        }
        if (user.getEmail() != "" && user.getEmail() != null){
            email = '"'+user.getEmail()+'"';
            newsql.append(" , email = "+email);
        }
        if (user.getTelephone() != "" && user.getTelephone() != null){
            telephone = '"'+user.getTelephone()+'"';
            newsql.append(" , telephone = "+telephone);
        }
        if (user.getUsername() != "" && user.getUsername() != null){
            username = '"'+user.getUsername()+'"';
            newsql.append(" where username = "+username);
        }
        sql = newsql.toString();
        jdbcTemplate.update(sql);
    }

    //    注销用户
    public void deleteUser(String username) {
        String sql = "delete from user where username = ?";
        jdbcTemplate.update(sql,username);
    }
}

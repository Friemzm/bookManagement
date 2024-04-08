package cn.pdsu.dao;

import cn.pdsu.bean.User;

public interface userDao {
//    查询用户
    public User findUserByUsername(String username);
//    添加用户
    public void addUser(User user);
//    登录验证
    public User userLogin(String username, String password);
//    更改用户信息
    public void updateUser(User user);
//    注销用户
    public void deleteUser(String username);

}

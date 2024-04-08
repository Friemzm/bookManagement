package cn.pdsu.service;

import cn.pdsu.bean.User;

public interface userService {
//    查询用户
    public User findUserByUsername(String useranme);
//    添加用户
    public void addUser(User user);
//    登陆验证
    public boolean userLogin(String username,String password);
    //    更改用户信息
    public void updateUser(User user);
    //    注销用户
    public void deleteUser(String username);
}

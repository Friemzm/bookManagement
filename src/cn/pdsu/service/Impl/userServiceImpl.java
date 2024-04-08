package cn.pdsu.service.Impl;

import cn.pdsu.bean.User;
import cn.pdsu.dao.impl.userDaoImpl;
import cn.pdsu.dao.userDao;
import cn.pdsu.service.userService;

public class userServiceImpl implements userService {
//    创建dao层对象
    private userDao dao = new userDaoImpl();

//    查询用户
    public User findUserByUsername(String username) {
        User user = dao.findUserByUsername(username);
        return user;
    }

//    添加用户
    public void addUser(User user) {
        dao.addUser(user);
    }

//  登陆验证
    public boolean userLogin(String username,String password) {
        User user1 = dao.userLogin(username,password);
        if (user1 != null){
//          姓名密码都正确
            return true;
        }else {
//          姓名或密码不正确
            return false;
        }
    }

//  更改用户信息
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    //    注销用户
    public void deleteUser(String username) {
        dao.deleteUser(username);
    }
}

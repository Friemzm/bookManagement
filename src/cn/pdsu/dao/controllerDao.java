package cn.pdsu.dao;

import cn.pdsu.bean.Controller;

public interface controllerDao {
//    查询管理员信息
    public Controller seekController();
//    根据书籍名称删除书籍
    public void deleteBook(String bookName);
}

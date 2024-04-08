package cn.pdsu.service.Impl;

import cn.pdsu.bean.Controller;
import cn.pdsu.dao.controllerDao;
import cn.pdsu.dao.impl.controllerDaoImpl;
import cn.pdsu.service.controllerService;

public class controllerServiceImpl implements controllerService {

//    创建dao层对象
    controllerDao dao = new controllerDaoImpl();
    //    查询管理员信息
    public Controller seekController() {
        Controller controller = dao.seekController();
        return controller;
    }

    //    根据书籍名称删除书籍
    public void deleteBook(String bookName) {
        dao.deleteBook(bookName);
    }
}

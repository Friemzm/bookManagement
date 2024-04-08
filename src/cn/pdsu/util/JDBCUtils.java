package cn.pdsu.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    //定义成员变量DataSource
    private static DataSource ds;

    //为变量DataSource进行初始化的赋值
    static {
        try {
            //创建Properties对象
            Properties pro = new Properties();
            //使用类加载器getClassLoader来加载配置文件
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取DataSource
            try {
                ds = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        //从连接池中取一个连接对象，返回一个Connection对象
        return ds.getConnection();
    }

    //释放资源
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }

    //重载释放资源
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

}
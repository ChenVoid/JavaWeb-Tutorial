package com.Void.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    JDBC快速入门-Connection
 */
public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();


        try {
            //开启事务
            conn.setAutoCommit(false);

            //5.执行sql
            int count1 = stmt.executeUpdate(sql1);

            //6.处理结果
            System.out.println(count1);
//            int i=3/0;
            //5.执行sql
            int count2 = stmt.executeUpdate(sql2);

            //6.处理结果
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (SQLException e) {
            //回滚事务
            conn.rollback();
            e.printStackTrace();
        }


        //7.释放资源
        stmt.close();
        conn.close();

    }
}

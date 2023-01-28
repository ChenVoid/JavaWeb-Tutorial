package com.Void.jdbc;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
    JDBC快速入门-Statement
 */
public class JDBCDemo4_Statement {

    /*
    执行DML语句
     */

    @Test
    public void testDML() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "update account set money = 2000 where id = 5";

        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql);

        //6.处理结果
        if(count > 0){
            System.out.println("修改成功");
        }
        else{
            System.out.println("修改失败");
        }

        //7.释放资源
        stmt.close();
        conn.close();

    }

    /*
    执行DDL语句
     */

    @Test
    public void testDDL() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "drop database db2";

        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql);

        //6.处理结果
//        if(count > 0){
//            System.out.println("修改成功");
//        }
//        else{
//            System.out.println("修改失败");
//        }
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();

    }

}

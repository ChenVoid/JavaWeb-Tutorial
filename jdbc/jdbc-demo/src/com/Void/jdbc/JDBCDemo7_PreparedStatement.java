package com.Void.jdbc;

import org.testng.annotations.Test;

import java.sql.*;

/*
    API详解: PreparedStatement
 */
public class JDBCDemo7_PreparedStatement {

    @Test
    public void testPreparedStatement() throws Exception {

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        //定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断登录是否成功
        if(rs.next()){
            System.out.println("登陆成功");
        }
        else{
            System.out.println("登陆失败");
        }

        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();


    }


    /*
    PreparedStatement原理
     */

    @Test
    public void testPreparedStatement2() throws Exception {

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        //定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断登录是否成功
        if(rs.next()){
            System.out.println("登陆成功");
        }
        else{
            System.out.println("登陆失败");
        }

        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();


    }



}

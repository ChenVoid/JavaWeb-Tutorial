package com.Void.druid;

/*
Druid数据库连接池演示
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo {

    public static void main(String[] args) throws Exception {
        //1.导入jar包

        //2.定义配置文件

        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
//        System.out.println(System.getProperty("user.dir"));

        //使用PreparedStatement登录
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

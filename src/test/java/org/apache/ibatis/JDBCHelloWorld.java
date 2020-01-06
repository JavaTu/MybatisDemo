package org.apache.ibatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC简单示例
 */
public class JDBCHelloWorld {

    public static void main(String[] args) throws Exception{

        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user", "root", "123456");

        // 创建Statement
        Statement stmt = conn.createStatement();

        // 执行SQL
        String sql = "select nick_name from zhw_user where id = 1";
        ResultSet rs = stmt.executeQuery(sql);

        // 获取结果
        while (rs.next()){
            System.out.println("用户昵称：" + rs.getString("nick_name"));
        }
    }
}

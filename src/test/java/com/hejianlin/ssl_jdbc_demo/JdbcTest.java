package com.hejianlin.ssl_jdbc_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SslJdbcApplication.class)
public class JdbcTest {

    @Test
    public void  test(){
        Connection conn=null;
        Statement sta=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://192.168.31.89:3306/test?verifyServerCertificate=true&useSSL=true&requireSSL=true";
            String username="root";
            String password="123456";
            conn= DriverManager.getConnection(url, username, password);
            sta=conn.createStatement();
            String sql="INSERT into a (id,sid,type) value (43,6,'dds')";
            int row=sta.executeUpdate(sql);
            System.out.println("增加行数："+row);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(sta!=null){
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

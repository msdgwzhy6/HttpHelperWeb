package com.http.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  private static Connection con = null;
  // 驱动程序名 
  private static String driverName = "com.mysql.jdbc.Driver"; 
  // 数据库用户名 
  private static String userName = "root"; 
  // 密码 1 
  private static String userPasswd = "1228";
  // 数据库名 
  private static String dbName = "http_helper_web";
  // 联结字符串 
  private static String url = "jdbc:mysql://localhost/" + dbName + "?user="
      + userName + "&password=" + userPasswd 
      + "&useUnicode=true&characterEncoding=gbk"; 
  public static Connection getConnection() { 
    try { 
      // 1.驱动 
      Class.forName(driverName); 
      // 2. 连接数据库 保持连接 
      con = DriverManager.getConnection(url);
      System.out.println("连接成功！");
    } catch (ClassNotFoundException e) { 
      // TODO Auto-generated catch block 
      e.printStackTrace(); 
    } catch (SQLException e) {
      // TODO Auto-generated catch block 
      e.printStackTrace(); 
    } 
    return con; 
  } 
  public static void closeConnection() { 
    if (con != null) { 
      try { 
        con.close(); 
      } catch (SQLException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
      } 
    } 
  } 
}

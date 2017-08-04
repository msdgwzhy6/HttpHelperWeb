package com.http.crud.user.util;

import com.http.crud.user.bean.UserBean;
import com.http.crud.connect.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.http.util.Util.logInfo;

/**
 * Created by smart on 2017/8/4.
 * function： 工具类，对 用户信息的 crud 操作
 */
public class UtilUserInfoCRUD {

    public static int add(String sql, UserBean userBean) {

        // 连接数据库 保持连接
        Connection con = DBConnection.getConnection();
        // 增加用prepareStatement
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userBean.getName());
            pstmt.setString(2, userBean.getPassword());
            pstmt.setInt(3, userBean.getAge());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.closeConnection();
        }
        return 0;
    }

    public static int modify(String sql, UserBean userBean) {
        return add(sql, userBean);
    }

    public static ResultSet query(String name) {

        String sql = "select name,password from users where name='" + name + "'";
        logInfo(sql);
        // 连接数据库 保持连接
        Connection con = DBConnection.getConnection();
        // 增加用prepareStatement
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            pstmt = con.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}

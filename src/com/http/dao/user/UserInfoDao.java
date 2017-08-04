package com.http.dao.user;

import com.http.bean.user.UserBean;
import com.http.dao.connect.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by smart on 2017/8/3.
 * function：对用户信息的 CRUD 操作
 */
public class UserInfoDao implements IUserInfoDao {
    @Override
    public int insert(UserBean userBean) {
        Connection con = DBConnection.getConnection();// 连接数据库 保持连接
        PreparedStatement pstmt = null;
        // 增加用prepareStatement
        String sql = " insert into users(user_account,user_password,user_age) values(?,?,?)";
        int count = 0;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userBean.getUser_account());
            pstmt.setString(2, userBean.getUser_password());
            pstmt.setInt(3, userBean.getUser_age());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            DBConnection.closeConnection();
        }
        return count;
    }

    @Override
    public void delete(String account) {

    }

    @Override
    public int update(UserBean userBean) {
        Connection con = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String sql = " update users " + " set user_account = ? , " + " user_password = ? , "
                + " user_age= ? " + " where id= ? ";
        int count = 0;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userBean.getUser_account());
            pstmt.setString(2, userBean.getUser_password());
            pstmt.setInt(3, userBean.getUser_age());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            DBConnection.closeConnection();
        }
        return count;

    }

    @Override
    public void select() {

    }
}

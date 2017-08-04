package com.http.crud.user;

import com.http.crud.user.bean.UserBean;
import com.http.crud.user.bean.UserLoginInfo;
import com.http.crud.user.constant.LoginInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.http.crud.user.util.UtilUserInfoCRUD.*;
import static com.http.util.Util.logInfo;

/**
 * Created by smart on 2017/8/3.
 * function：对用户信息的 CRUD 操作
 */
public class UserInfoCRUD implements IUserInfoCRUD {
    @Override
    public int insert(UserBean userBean) {
        String sql = " insert into users(name,password,age) values(?,?,?)";
        return add(sql, userBean);
    }

    @Override
    public void delete(String account) {

    }

    @Override
    public int update(UserBean userBean) {
        String sql = " update users " + " set name = ? , " + " password = ? , "
                + " age= ? " + " where name= " + userBean.getName();
        logInfo(sql);
        return modify(sql, userBean);

    }

    @Override
    public UserLoginInfo select(String name, String password) {
        ResultSet resultSet = query(name);
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        try {
            boolean loop = true;
            while (loop) {
                if (resultSet.next()) {
                    loop = false;
                    logInfo("数据校验！" + resultSet.getString("password"));
                    if (!password.equals(resultSet.getString("password"))) {
                        userLoginInfo.setUserLoginInfo(LoginInfo.CODE_PASSWORD_ERROR, LoginInfo.INFO_PASSWORD_ERROR);
                    } else {
                        userLoginInfo.setUserLoginInfo(LoginInfo.CODE_LOGIN_SUCCESS, LoginInfo.INFO_LOGIN_SUCCESS);
                    }
                } else {
                    loop = false;
                    logInfo("账号不存在");
                    userLoginInfo.setUserLoginInfo(LoginInfo.CODE_ACCOUNT_NOT_EXIST, LoginInfo.INFO_ACCOUNT_NOT_EXIST);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userLoginInfo;
    }

}

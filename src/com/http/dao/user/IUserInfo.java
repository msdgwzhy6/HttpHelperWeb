package com.http.dao.user;

import com.http.dao.user.bean.UserBean;
import com.http.dao.user.bean.UserLoginInfo;

/**
 * Created by smart on 2017/8/3.
 */
public interface IUserInfo {
    /** 向数据库增加一条记录
     * @param userBean 用户
     */
    int insert(UserBean userBean);

    /** 删除用账户
     * @param account 账户名
     */
    void delete(String account);

    /** 更新账户信息
     * @param userBean 用户
     */
    int update(UserBean userBean);

    /** 查询数据
     *
     * @param account
     * @param password
     */
    UserLoginInfo select(String account, String password);
}

package com.http.servlet.user;

import com.alibaba.fastjson.JSON;
import com.http.constant.Code;
import com.http.dao.user.UserInfoDao;
import com.http.dao.user.bean.UserBean;
import com.http.dao.user.bean.UserLoginInfo;
import com.http.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.http.constant.Constant.*;
import static com.http.util.Util.logInfo;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet  {
    private static final long serialVersionUID = 1L;

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        log("登录！！！！！！！！！！！！！！！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);


        OutputStream outputStream = response.getOutputStream();
        String account = new String(request.getParameter("account").getBytes(CHART_SET_ISO_8859_1), CHART_SET_UTF_8);//账号
        String password = request.getParameter("password");//密码

        UserInfoDao userInfoDao = new UserInfoDao();//业务类
        UserLoginInfo userLoginInfo;//反馈信息实体类
        byte[] jsonBytes = null;//输出字节数组

        /*参数取值检查*/
        if (Util.isEmpty(password)) {
            userLoginInfo = new UserLoginInfo();
            userLoginInfo.setUserLoginInfo(Code.CODE_PASSWORD_ERROR, Code.INFO_PASSWORD_ERROR);
            jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
            outputStream.write(jsonBytes);
        }
        if (Util.isEmpty(account)) {
            userLoginInfo = new UserLoginInfo();
            userLoginInfo.setUserLoginInfo(Code.CODE_ACCOUNT_ERROR, Code.INFO_ACCOUNT_ERROR);
            jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
            outputStream.write(jsonBytes);
        }
        String tag = request.getParameter("tag");
        log(tag);
        switch (tag) {
            case TAG_LOGIN:
                userLoginInfo = userInfoDao.select(account, password);
                jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
                break;
            case TAG_REGISTER:
                //新增
                int age = Integer.parseInt(request.getParameter("age"));//年龄
                UserBean userBean = new UserBean();
                userBean.setName(account);
                userBean.setPassword(password);
                userBean.setAge(age);
                logInfo(userBean.getName());
                int count = userInfoDao.insert(userBean);
                userLoginInfo = new UserLoginInfo();
                if (count!=0) {//注册成功
                    userLoginInfo.setUserLoginInfo(Code.CODE_REGISTER_SUCCESS,Code.INFO_REGISTER_SUCCESS);
                }else {
                    userLoginInfo.setUserLoginInfo(Code.CODE_REGISTER_ERROR,Code.INFO_REGISTER_ERROR);
                }
                jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
                break;
            case TAG_DELETE:
                //删除
                break;
            case TAG_UPDATE:
                //更新
                break;
        }
        if (jsonBytes != null) {
            outputStream.write(jsonBytes);//输出响应数据
        }else {
            userLoginInfo = new UserLoginInfo();
            userLoginInfo.setUserLoginInfo(Code.CODE_SERVER_ERROR,Code.INFO_SERVER_ERROR);
            jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
            outputStream.write(jsonBytes);//输出响应数据
        }
        outputStream.flush();
        outputStream.close();
    }

}

package com.http.servlet.login;

import com.alibaba.fastjson.JSON;
import com.http.bean.UserLogin;
import com.http.constant.CodeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.http.constant.Constant.CHART_SET_UTF_8;
import static com.http.constant.Constant.CONTENT_TYPE;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");

        String password = request.getParameter("password");

        /*
        * 去数据库查询用户信息
        * */

        String userJson = "";
        response.setContentType(CONTENT_TYPE);

        OutputStream outputStream = response.getOutputStream();

        userJson = JSON.toJSONString(buildUserDO(CodeInfo.CODE_LOGIN_ERROR, CodeInfo.INFO_LOGIN_ERROR));

        outputStream.write(userJson.getBytes(CHART_SET_UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    private UserLogin buildUserDO( String errorCode, String msg) {
        UserLogin user = new UserLogin();
        user.setErrorCode(errorCode);
        user.setMsg(msg);
        return user;
    }

}

package com.http.servlet.login;

import com.alibaba.fastjson.JSON;
import com.http.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import static com.http.constant.Constant.CHART_SET_ISO_8859_1;
import static com.http.constant.Constant.CONTENT_TYPE;
import static com.http.constant.Constant.CHART_SET_UTF_8;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = null;
        String nameTemp = request.getParameter("name");
        String password = request.getParameter("password");

        response.setContentType(CONTENT_TYPE);
        OutputStream outputStream = response.getOutputStream();
        StringBuilder backInfo = new StringBuilder();//反馈信息
        if (nameTemp == null) {
            backInfo.append("请输入用户名！");
        } else {
            name = new String(nameTemp.getBytes("iso-8859-1"), CHART_SET_UTF_8);
        }
        if (password == null) {
            backInfo.append("请输入年龄");
        }
        if (name != null && password != null) {
            backInfo.replace(0, backInfo.length(), "登陆成功！");
        }
        String msg = new String(backInfo.toString().getBytes());
        String userJson = JSON.toJSONString(buildUserDO(name, password, msg));
        outputStream.write(userJson.getBytes(CHART_SET_UTF_8));
        outputStream.flush();
        outputStream.close();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = null;

        String nameTemp = request.getParameter("name");

        String psw = request.getParameter("password");

        response.setContentType(CONTENT_TYPE);

        OutputStream outputStream = response.getOutputStream();

        StringBuilder backInfo = new StringBuilder();//反馈信息
        if (nameTemp == null || nameTemp == "") {
            backInfo.append("请输入用户名！");
        } else {
            name = new String(nameTemp.getBytes(CHART_SET_ISO_8859_1), CHART_SET_UTF_8);
        }
        if (psw == null || psw == "") {
            backInfo.append("请输入年龄");
        }
        if (name != null && psw != null) {
            backInfo.replace(0, backInfo.length(), "登陆成功！");
        }
        String msg = backInfo.toString();
        String userJson = JSON.toJSONString(buildUserDO(name, psw, msg));
        outputStream.write(userJson.getBytes(CHART_SET_UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    private User buildUserDO(String name, String psw, String msg) {
        User user = new User();
        user.setName(name);
        user.setPassword(psw);
        user.setAge(11);
        user.setBirthday(new Date());
        user.setMsg(msg);
        return user;
    }

}

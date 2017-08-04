package com.http.servlet.user;

import com.http.crud.user.UserInfoCRUD;
import com.http.crud.user.bean.UserBean;
import com.http.crud.user.bean.UserLoginInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.http.crud.user.constant.Constant.CHART_SET_ISO_8859_1;
import static com.http.crud.user.constant.Constant.CHART_SET_UTF_8;
import static com.http.crud.user.constant.Constant.CONTENT_TYPE;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
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

        String account = new String(request.getParameter("account").getBytes(CHART_SET_ISO_8859_1),CHART_SET_UTF_8);
        String password = request.getParameter("password");
//        int age = Integer.parseInt(request.getParameter("age"));
        /*信息检查*/
        if (password == null) {
            outputStream.write("您的账号或密码输入为空！".getBytes());
            return;
        }
        /*信息验证*/

        UserBean userBean = new UserBean();
        userBean.setName(account);
        userBean.setPassword(password);
        userBean.setPassword(password);
//        userBean.setAge(age);
        outputStream.write(new UserInfoCRUD().select(account, password).getMsg().getBytes());
       /*

        *//*
        * 去数据库查询用户信息
        * *//*

        String userJson = "";




        userJson = JSON.toJSONString(buildUserDO(LoginInfo.CODE_LOGIN_ERROR, LoginInfo.INFO_LOGIN_ERROR));


        outputStream.flush();
        outputStream.close();*/
    }

    private UserLoginInfo buildUserDO(String errorCode, String msg) {
        UserLoginInfo user = new UserLoginInfo();
        return user;
    }

    // 新增
    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String account = request.getParameter("account");

        String password = request.getParameter("password");

       /* String dName = request.getParameter("displayName");
        User user = new User();
        user.setUserName(uName);
        user.setPwd(pwd);
        user.setDisplayName(dName);
        UserDao uDao = new UserDao();
        int affCount = uDao.insert(user);
        PrintWriter out = response.getWriter();
        // 将受影响数据的数量返回给jsp
        out.print(affCount);*/
    }

    // 删除
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        /*String[] ids = request.getParameterValues("uid[]");
        UserDao ud = new UserDao();
        int count = 0;
        for (int i = 0; i < ids.length; i++) {
            count += ud.delete(Integer.parseInt(ids[i]));
        }
        PrintWriter out = response.getWriter();
        out.print(count);*/
    }

    // 查询
    public void select(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
       /* String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        System.out.println("page:" + page + " rows:" + rows);
        UserDao ud = new UserDao();
        int rowsCount = Integer.parseInt(rows);
        int from = (Integer.parseInt(page) - 1) * rowsCount;
        List<User> list = ud.selectPage(from, rowsCount);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", ud.selectCount());
        map.put("rows", list);
        // JSONArray ja = JSONArray.fromObject(list);
        JSONObject jo = JSONObject.fromObject(map);// 单条数据
        PrintWriter out = response.getWriter();
        System.out.println(jo.toString());
        // 将json数据返回给jspData-grid的url。
        out.println(jo.toString());*/
    }

    // 修改
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
     /*   String id = request.getParameter("id");
        String uName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String dName = request.getParameter("displayName");
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUserName(uName);
        user.setPwd(pwd);
        user.setDisplayName(dName);
        UserDao uDao = new UserDao();
        int affCount = uDao.upDate(user);
        PrintWriter out = response.getWriter();
        // 将受影响数据的数量返回给jsp
        out.print(affCount);*/
    }

}

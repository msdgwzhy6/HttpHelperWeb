package com.http.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by smart on 2017/8/3.
 */
public interface IUserLoginServlet {
    // 新增
    void insert(HttpServletRequest request, HttpServletResponse response)
            throws IOException;

    // 删除
    void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException;

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    void init() throws ServletException;

    // 查询
    void select(HttpServletRequest request, HttpServletResponse response)
            throws IOException;

    // 修改
    void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException;

}

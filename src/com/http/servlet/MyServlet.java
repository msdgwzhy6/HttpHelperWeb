package com.http.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.http.bean.User;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameTemp = request.getParameter("name");
		String name = new String(nameTemp.getBytes("iso-8859-1"),"utf-8");
		String age = request.getParameter("age");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =  response.getWriter();
		out.print("name = "+name+"; age = " + age); 
		System.out.println("name = "+name+"; age = " + age);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8");  
        
		String nameTemp = request.getParameter("name");
		String name = new String(nameTemp.getBytes("iso-8859-1"),"utf-8");
		String age = request.getParameter("age");
		
		OutputStream out =  response.getOutputStream();
	    String userJson = JSON.toJSONString(buildUserDO());  
		out.write(userJson.getBytes("UTF-8"));  
		System.out.println("name = "+name+"; age = " + age);
	}
	  private User buildUserDO(){
	        User user = new User();  
	        user.setName("王二麻子");  
	        user.setPassword("sdgsgd");  
	        user.setAge(11);  
	        user.setBirthday(new Date());  
	          
	        return user;  
	    }  

}

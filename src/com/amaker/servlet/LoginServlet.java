package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.UserDao;
import com.amaker.dao.impl.UserDaoImpl;
import com.amaker.entity.User;

/**
 *响应客户端发来的请求 
 **/
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	public void init () throws ServletException {	}
	
	public LoginServlet () {
		super ();
	}
	
	public void destroy () {
		super.destroy();
	}
	
	// 将用户对象转换为字符串返给客户端
	private String build(User u) {
		String userMsg = "";
		userMsg += ("id=" + u.getId());
		userMsg += ";";
		userMsg +=("name=" + u.getName());
		return userMsg;
	}
		
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			UserDao dao = new UserDaoImpl();
			
			// 获取客户端请求参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User u = dao.login(username, password);
			if (u != null) {
				// 响应客户端内容，登录成功
				out.print(build(u));
				System.out.println("111111111");
			} else {
				out.print("0");
				System.out.println("22222222222222");
			}
			out.flush(); // 立即将缓冲区的数据输出到接收方
			out.close(); // 关闭输出流
	}	
	public void doPost (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			doGet(request,response);
	}
}

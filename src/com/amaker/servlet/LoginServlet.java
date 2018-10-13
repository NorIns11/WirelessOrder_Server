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
 *��Ӧ�ͻ��˷��������� 
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
	
	// ���û�����ת��Ϊ�ַ��������ͻ���
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
			
			// ��ȡ�ͻ����������
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User u = dao.login(username, password);
			if (u != null) {
				// ��Ӧ�ͻ������ݣ���¼�ɹ�
				out.print(build(u));
				System.out.println("111111111");
			} else {
				out.print("0");
				System.out.println("22222222222222");
			}
			out.flush(); // ��������������������������շ�
			out.close(); // �ر������
	}	
	public void doPost (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			doGet(request,response);
	}
}

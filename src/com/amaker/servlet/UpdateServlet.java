package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.UpdateDao;
import com.amaker.dao.impl.UpdateDaoImpl;
import com.amaker.entity.Menu;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void destory(){
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UpdateDao dao = new UpdateDaoImpl();
		@SuppressWarnings("rawtypes")
		List list = dao.getMenuList();
		out.println("<?xml version='1.0' encoding='UTF-8'?>");
		out.println("<menulist>");
		for(int i=0; i<list.size(); i++){
			Menu menu = (Menu)list.get(i);
			out.println("<menu>");
			out.print("<id>");
			out.print(menu.getId());
			out.println("</id>");
			out.print("<typeId>");
			out.print(menu.getTypeId());
			out.println("</typeId>");
			out.print("<name>");
			out.print(menu.getName());
			out.println("</name>");
			out.print("<pic>");
			out.print(menu.getPic());
			out.println("</pic>");
			out.print("<price>");
			out.print(menu.getPrice());
			out.println("</price>");
			out.print("<remark>");
			out.print(menu.getRemark());
			out.println("</remark>");
			out.println("</menu>");
		}
		out.println("</menulist>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	public void init() throws ServletException{
		
	}

}

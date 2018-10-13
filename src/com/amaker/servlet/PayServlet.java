package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.PayDao;
import com.amaker.dao.impl.PayDaoImpl;
import com.amaker.entity.QueryOrderDetail;

/**
 * Servlet implementation class PayServlet
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init () throws ServletException{
    }
    
    public void destroy() {
    	super.destroy();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		PayDao dao = new PayDaoImpl();
		String id = request.getParameter("id");
		
		if(id != "") {
		// 	QueryOrder qo = dao.getOrderById(Integer.parseInt(id));
			@SuppressWarnings("rawtypes")
			List list = dao.getOrderDetailList(Integer.parseInt(id));
			// 拼接成HTML页面
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			out.print("<table style='text-align:center;'>");
			
				out.print("<tr>");
					out.print("<th width='150px'>");
					out.print("订单编号");
					out.print("</th>");
					out.print("<th style='width:150px;text-align:left;'>");
					out.print(id);
					out.print("</th>");
				out.print("</tr>");
				
				out.print("<tr>");
					out.print("<th width='150px'>");
					out.print("菜名");
					out.print("</th>");
					out.print("<th width='50px'>");
					out.print("价格");
					out.print("</th>");
					out.print("<th width='50px'>");
					out.print("数量");
					out.print("</th>");
					out.print("<th width='80px'>");
					out.print("总计");
					out.print("</th>");
				out.print("</tr>");
				
				for (int i=0;i<list.size();i++) {
					QueryOrderDetail qod = (QueryOrderDetail) list.get(i) ;
					String name = qod.getName();
					int price = qod.getPrice();
					int num = qod.getNum();
					int total = qod.getTotal();
					
					out.print("<tr>");
						out.print("<td width='150px'>");
						out.print(name);
						out.print("</td>");
						out.print("<td width='50px'>");
						out.print(price==0 ? "" :price + "元");
						out.print("</td>");
						out.print("<td width='50px'>");
						out.print(num==0 ? "" :num + "份");
						out.print("</td>");
						out.print("<td width='80px'>");
						out.print(total + "元");
						out.print("</td>");
					out.print("</tr>");
				}

			out.print("</table>");
			out.println("</body>");
			out.println("</html>");
		}
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
}

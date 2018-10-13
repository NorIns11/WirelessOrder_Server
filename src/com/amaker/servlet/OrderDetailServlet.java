package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.OrderDao;
import com.amaker.dao.impl.OrderDaoImpl;
import com.amaker.entity.OrderDetail;

/**
 * Servlet implementation class OrderDetailServlet
 */
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String orderId = request.getParameter("orderId");
		String menuId = request.getParameter("menuId");
		String num = request.getParameter("num");
		String remark = request.getParameter("remark");
		String tableId = request.getParameter("tableId");
		String price = request.getParameter("price");
		String name = request.getParameter("name");
		
		OrderDao dao = new OrderDaoImpl();
		OrderDetail od = new OrderDetail();
		
		od.setMenuId(Integer.parseInt(menuId));
		od.setOrderId(Integer.parseInt(orderId));
		od.setNum(Integer.parseInt(num));
		od.setRemark(remark);
		od.setTableId(Integer.parseInt(tableId));
		od.setPrice(Integer.parseInt(price));
		od.setName(name);
		
		dao.saveOrderDetail(od);
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

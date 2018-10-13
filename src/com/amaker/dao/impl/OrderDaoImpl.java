package com.amaker.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.amaker.dao.OrderDao;
import com.amaker.entity.OrderDetail;
import com.amaker.util.DBUtil;
import com.mysql.jdbc.Connection;

public class OrderDaoImpl implements OrderDao{
	public void saveOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		String sql = "insert into orderdetailtbl(orderId,menuId,num,remark,tableId, price, name)values(?,?,?,?,?,?,?)";
		DBUtil util = new DBUtil();
		Connection conn = (Connection) util.openConnection();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderDetail.getOrderId());
			pstmt.setInt(2, orderDetail.getMenuId());
			pstmt.setInt(3, orderDetail.getNum());
			pstmt.setString(4, orderDetail.getRemark());
			pstmt.setInt(5, orderDetail.getTableId());
			pstmt.setInt(6, orderDetail.getPrice());
			pstmt.setString(7, orderDetail.getName());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			util.closeConn(conn);
		}
	}
	

}

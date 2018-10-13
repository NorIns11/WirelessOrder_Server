package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amaker.dao.PayDao;
import com.amaker.entity.QueryOrderDetail;
import com.amaker.util.DBUtil;

public class PayDaoImpl implements PayDao{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getOrderDetailList(int id) {
		String sql = "select name,  price, num, price*num as total from orderdetailtbl where orderId = ?";
		DBUtil util = new DBUtil (); 				// 数据库连接工具类
		Connection conn = util.openConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置查询参数
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			// 判断订单详情
			List list = new ArrayList();
			while(rs.next()) {
				String name = rs.getString(1);
				int price = rs.getInt(2);
				int num = rs.getInt(3);
				int total = rs.getInt(4);
				
				QueryOrderDetail qod = new QueryOrderDetail();
				qod.setName(name);
				qod.setNum(num);
				qod.setPrice(price);
				qod.setTotal(total);
				
				list.add(qod);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}
	
	public void pay (int id) {
		String sql = " update orderdetailtbl set isPay=1 where orderId=? ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}
}

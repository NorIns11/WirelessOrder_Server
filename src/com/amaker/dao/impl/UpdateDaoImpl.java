package com.amaker.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amaker.dao.UpdateDao;
import com.amaker.entity.Menu;
import com.amaker.util.DBUtil;
import com.mysql.jdbc.Connection;

public class UpdateDaoImpl implements UpdateDao{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getMenuList() {
		// TODO Auto-generated method stub
		String sql = "select id,typeId,price,name,pic,remark from MenuTbl";
		DBUtil util = new DBUtil();
		Connection conn = (Connection) util.openConnection();
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			List list = new ArrayList();
			while(result.next()){
				int id = result.getInt(1);
				int typeId = result.getInt(2);
				int price = result.getInt(3);
				String name = result.getString(4);
				String pic = result.getString(5);
				String remark = result.getString(6);
				Menu menu = new Menu();
				menu.setId(id);
				menu.setName(name);
				menu.setPic(pic);
				menu.setPrice(price);
				menu.setRemark(remark);
				menu.setTypeId(typeId);
				list.add(menu);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			util.closeConn(conn);
		}
		return null;
	}

}

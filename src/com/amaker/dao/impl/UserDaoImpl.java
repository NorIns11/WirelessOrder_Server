package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amaker.dao.UserDao;
import com.amaker.entity.User;
import com.amaker.util.DBUtil;

public class UserDaoImpl implements UserDao {
	// 登录成功返回User对象
	public User login(String username, String password) {
		// SQL查询语句
		String sql = "select id,username,password from UserTbl where username=? and password=?";
		// 实例化数据库工具类
		DBUtil util = new DBUtil();
		// 获得数据库连接
		Connection conn = util.openConnection();
		try {
			// 创建预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置查询参数
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// 结果集
			ResultSet rs = pstmt.executeQuery();
			// 判断该用户是否存在
			if (rs.next()) {
				int id = rs.getInt(1);
				User u = new User();
				// 设置User属性
				u.setId(id);
				u.setPassword(password);
				u.setName(username);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}
}

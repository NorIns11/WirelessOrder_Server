package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amaker.dao.UserDao;
import com.amaker.entity.User;
import com.amaker.util.DBUtil;

public class UserDaoImpl implements UserDao {
	// ��¼�ɹ�����User����
	public User login(String username, String password) {
		// SQL��ѯ���
		String sql = "select id,username,password from UserTbl where username=? and password=?";
		// ʵ�������ݿ⹤����
		DBUtil util = new DBUtil();
		// ������ݿ�����
		Connection conn = util.openConnection();
		try {
			// ����Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò�ѯ����
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// �����
			ResultSet rs = pstmt.executeQuery();
			// �жϸ��û��Ƿ����
			if (rs.next()) {
				int id = rs.getInt(1);
				User u = new User();
				// ����User����
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

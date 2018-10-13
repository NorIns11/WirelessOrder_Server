package com.amaker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	/**
	 * ���ݿ⹤����
	 */
	
	// �ر����ݿ�����
	public void closeConn (Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// �����ݿ�����
	public Connection openConnection () {
		// ʵ����Properties
		Properties prop = new Properties ();
		// ����
		String driver = null;
		// ���ݿ������url
		String url = null;
		// �û�����
		String username = null;
		// ����
		String password = null;
		
		try {
			// ���������ļ�
			prop.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			// ������ݿ������Ϣ
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			// ע������
			Class.forName(driver);
			// �������ݿ�����
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace ();
		}
		return null;
	}
}


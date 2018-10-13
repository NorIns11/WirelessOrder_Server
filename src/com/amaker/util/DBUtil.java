package com.amaker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	/**
	 * 数据库工具类
	 */
	
	// 关闭数据库连接
	public void closeConn (Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 打开数据库连接
	public Connection openConnection () {
		// 实例化Properties
		Properties prop = new Properties ();
		// 驱动
		String driver = null;
		// 数据库库连接url
		String url = null;
		// 用户名称
		String username = null;
		// 密码
		String password = null;
		
		try {
			// 加载配置文件
			prop.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			// 获得数据库相关信息
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			// 注册驱动
			Class.forName(driver);
			// 返回数据库连接
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace ();
		}
		return null;
	}
}


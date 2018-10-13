package com.amaker.dao;

import com.amaker.entity.User;

public interface UserDao {
	// 登录方法，返回User实例
	public User login(String username, String password);
}

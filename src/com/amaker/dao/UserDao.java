package com.amaker.dao;

import com.amaker.entity.User;

public interface UserDao {
	// ��¼����������Userʵ��
	public User login(String username, String password);
}

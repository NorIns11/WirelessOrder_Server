package com.amaker.dao;

import java.util.List;

public interface PayDao {
	// 查询订单详细信息
	@SuppressWarnings("rawtypes")
	public List getOrderDetailList(int id);
	// 结算
	public void pay(int id);	
}

package com.amaker.dao;

import com.amaker.entity.OrderDetail;

public interface OrderDao {
	//保存点菜列表信息
	public void saveOrderDetail(OrderDetail orderDetail);

}

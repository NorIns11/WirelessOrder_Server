package com.amaker.dao;

import java.util.List;

public interface PayDao {
	// ��ѯ������ϸ��Ϣ
	@SuppressWarnings("rawtypes")
	public List getOrderDetailList(int id);
	// ����
	public void pay(int id);	
}

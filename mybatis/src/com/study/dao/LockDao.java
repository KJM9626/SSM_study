package com.study.dao;

import com.study.bean.Lock;

public interface LockDao {
	
	//���ʱ������е�Կ��Ҳ�����
	public Lock getLockById(Integer id);
	public Lock getLockByIdSimple(Integer id);
//	�ֲ���ѯ
	public Lock getLockByStep(Integer id);

}

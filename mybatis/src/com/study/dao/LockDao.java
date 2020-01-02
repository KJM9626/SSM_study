package com.study.dao;

import com.study.bean.Lock;

public interface LockDao {
	
	//查的时候把所有的钥匙也查出来
	public Lock getLockById(Integer id);
	public Lock getLockByIdSimple(Integer id);
//	分部查询
	public Lock getLockByStep(Integer id);

}

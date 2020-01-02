package com.study.dao;

import java.util.List;

import com.study.bean.Key;

public interface KeyDao {

	public Key getKeyById(Integer id);
	public Key getKeyByIdSimple(Integer id);
//	按照锁的id查出所有的钥匙key
	public List<Key> getKeyByLockId(Integer id);

}

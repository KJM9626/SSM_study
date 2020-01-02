package com.study.dao;

import java.util.List;

import com.study.bean.Key;

public interface KeyDao {

	public Key getKeyById(Integer id);
	public Key getKeyByIdSimple(Integer id);
//	��������id������е�Կ��key
	public List<Key> getKeyByLockId(Integer id);

}

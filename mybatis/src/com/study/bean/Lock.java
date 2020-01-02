package com.study.bean;

import java.io.Serializable;
import java.util.List;

public class Lock implements Serializable{
	private Integer id;//��id
	private String lockName;//����
	private List<Key> keys;//��ѯ����ʱ������еĹ�����Կ��Ҳ�����
	@Override
	public String toString() {
		return "Lock [id=" + id + ", lockName=" + lockName + ", keys=" + keys + "]";
	}


	public Lock(Integer id, String lockName, List<Key> keys) {
		super();
		this.id = id;
		this.lockName = lockName;
		this.keys = keys;
	}


	public Lock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLockName() {
		return lockName;
	}
	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public List<Key> getKeys() {
		return keys;
	}

	public void setKeys(List<Key> keys) {
		this.keys = keys;
	}
	

}

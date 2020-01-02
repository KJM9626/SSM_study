package com.study.bean;

import java.io.Serializable;

public class Key implements Serializable{
	
	private Integer id;//Ô¿³×id
	private String keyName;//Ô¿³×Ãû
	private Lock lock;//Ò»Ô¿³×--Ò»Ëø
	public Key() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Key(Integer id, String keyName, Lock lock) {
		super();
		this.id = id;
		this.keyName = keyName;
		this.lock = lock;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	@Override
	public String toString() {
		return "Key [id=" + id + ", keyName=" + keyName + ", lock=" + lock + "]";
	}
	
	

}

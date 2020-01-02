package com.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.bean.Teacher;

public interface TeacherDao {
	
	public Teacher getTeacherById(Integer id);
	
	/**
	 * @param teacher
	 * @return
	 * ����teacher����Ķ�������Ĳ�����ѯ��ͬ
	 */
	public List<Teacher> getTeacherByCondition(Teacher teacher);
	
	public List<Teacher> getTeachers(@Param("ids")List<Integer> ids);
	
	public List<Teacher> getTeacherByConditionChoose(Teacher teacher);

	public int updateTeacher(Teacher teacher);
	
	/**
	 * @param list
	 * ��������Teacher
	 */
	void insertBatch(@Param("teachers")List<Teacher>list);
}

package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Focus;
import com.revature.hibernate.model.Skill;

public interface FocusDao {

	void insertFocus(Focus focus);
	List<Focus> selectAllFocuses();
	Focus selectFocusByName(String name);
	Focus selectFocusById(int id);
	void deleteFocus(String name);
	void deleteFocus(int id);
	void addSkill(String focusName, Skill skill);
	
}

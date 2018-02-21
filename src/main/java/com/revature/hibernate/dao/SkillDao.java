package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Skill;

public interface SkillDao {

	void insertSkill(Skill skill);
	void deleteSkill(String skillName);
	Skill selectSkill(String skillName);
	List<Skill> selectAllSkills();
}

package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Skill;
import com.revature.hibernate.model.Trainer;

public interface TrainerDao {

	void insertTrainer(Trainer trainer);
	List<Trainer> selectAllTrainers();
	Trainer selectTrainerByName(String trainerFirstName, String trainerLastName);
	Trainer selectTrainerById(int id);
	void deleteTrainer(String trainerFirstName, String trainerLastName);
	void addSkill(String trainerFirstName, String trainerLastName, Skill skill);
}

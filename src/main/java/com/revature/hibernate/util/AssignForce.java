package com.revature.hibernate.util;

import java.util.List;

import com.revature.hibernate.dao.BatchDaoImpl;
import com.revature.hibernate.dao.CurriculumDaoImpl;
import com.revature.hibernate.dao.FocusDaoImpl;
import com.revature.hibernate.dao.LocationDaoImpl;
import com.revature.hibernate.dao.SkillDaoImpl;
import com.revature.hibernate.dao.TrainerDaoImpl;
import com.revature.hibernate.model.Batch;
import com.revature.hibernate.model.Curriculum;
import com.revature.hibernate.model.Focus;
import com.revature.hibernate.model.Location;
import com.revature.hibernate.model.Room;
import com.revature.hibernate.model.Skill;
import com.revature.hibernate.model.Trainer;

public class AssignForce {

	
	public static List<Batch> getAllBatches() {
		return BatchDaoImpl.getInstance().selectAllBatches();
	}
	
	public static List<Location> getAllLocation() {
		return LocationDaoImpl.getInstance().selectAllLocations();
	}
	
	public static List<Curriculum> getAllCurriculum() {
		return CurriculumDaoImpl.getInstance().selectAllCurriculum();
	}
	
	public static List<Trainer> getAllTrainers() {
		return TrainerDaoImpl.getInstance().selectAllTrainers();
	}
	
	public static List<Focus> getAllFocuses() {
		return FocusDaoImpl.getInstance().selectAllFocuses();
	}
	
	public static List<Room> getAllRooms() {
		return LocationDaoImpl.getInstance().selectAllRooms();
	}
	
	public static List<Skill> getAllSkills() {
		return SkillDaoImpl.getInstance().selectAllSkills();
	}
	
	
	
	
	public static void main(String[] args) {
		List<Batch> batches = AssignForce.getAllBatches();
//		List<Curriculum> curricula = AssignForce.getAllCurriculum();
//		List<Location> locations = AssignForce.getAllLocation();
//		List<Trainer> trainers = AssignForce.getAllTrainers();
//		
//		for (Batch b : batches) {
//			System.out.println("Batch: " + b.getBatchName());
//			System.out.println("Trainer: " + b.getTrainer().getTrainerFirstName() + " " + b.getTrainer().getTrainerLastName());
//			for (Skill s : b.getTrainer().getTrainerSkill()) {
//				System.out.println("Trainer Skill: " + s.getSkillName());
//			}
//			System.out.println("Curriculum: " + b.getCurriculum().getCurriculumName());
//			for (Skill s : b.getCurriculum().getCurriculumSkill()) {
//				System.out.println("Curriculum Skill: " + s.getSkillName());
//			}
//			System.out.println("Focus: " + b.getFocus().getFocusName());
//			for (Skill s : b.getFocus().getFocusSkill()) {
//				System.out.println("Focus Skill: " + s.getSkillName());
//			}
//			
//		}
//		System.out.println("=====================================");
//		
//		for (Curriculum c : curricula) {
//			System.out.println("Curriculum: " + c.getCurriculumName());
//			for (Skill s : c.getCurriculumSkill()) {
//				System.out.println("Curriculum Skill: " + s.getSkillName());
//			}
//			
//		}
//		
//		System.out.println("=====================================");
//		
//		for (Trainer t : trainers) {
//			System.out.println("Trainer Name: " + t.getTrainerFirstName() + " " + t.getTrainerLastName());
//			for (Skill s : t.getTrainerSkill()) {
//				System.out.println("Trainer Skill: " + s.getSkillName());
//			}
//		}
//		System.out.println("=====================================");
//		
//		for (Location l : locations) {
//			System.out.println("Location: " + l.getLocationName());
//			for (Building b : l.getBuildings()) {
//				System.out.println("Building: " + b.getBuildingName());
//				for (Room r : b.getRooms()) {
//					System.out.println("Room: " + r.getRoomNumber());
//				}
//			}
//		}
		
		Batch batch = batches.get(0);
		System.out.println("Batch: "+batch.getBatchName());
		System.out.println("Trainer: " + batch.getTrainer().getTrainerFirstName() + " " + batch.getTrainer().getTrainerLastName());
		for (Skill s : batch.getTrainer().getTrainerSkill()) {
			System.out.println("Trainer Skill: " + s.getSkillName());
		}
		System.out.println("Curriculum: "+batch.getCurriculum().getCurriculumName());
		for (Skill s : batch.getCurriculum().getCurriculumSkill()) {
			System.out.println("Curriculum Skill: "+s.getSkillName());
		}
		System.out.println("Focus: " + batch.getFocus().getFocusName());
		for (Skill s : batch.getFocus().getFocusSkill()) {
			System.out.println("Focus Skill: " + s.getSkillName());
		}
		System.out.println("Location: "+batch.getRoom().getBuilding().getLocation().getLocationName());
		System.out.println("Building: " + batch.getRoom().getBuilding().getBuildingName());
		System.out.println("Room: " + batch.getRoom().getRoomNumber());
		
		
		
	}
	
	
}

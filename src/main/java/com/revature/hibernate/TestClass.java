package com.revature.hibernate;

import java.util.List;

import com.revature.hibernate.dao.BatchDaoImpl;
import com.revature.hibernate.model.Batch;
import com.revature.hibernate.model.Skill;

public class TestClass {

	
	public static void main(String[] args) {
//		Location location = new Location("Northwest HQ", "Portland", "Oregon");
//		LocationDaoImpl.getInstance().insertLocation(location);
//	
//		Building b1 = new Building("NW Test 1");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b1);
//		
//		Building b2 = new Building("NW Test 2");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b2);
//		
//		Building b3 = new Building("NW Test 3");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b3);
//		
//		Room r1 = new Room("101A");
//		LocationDaoImpl.getInstance().addRoom(b1.getBuildingName(), r1);
//		
//		Room r2 = new Room("202B");
//		LocationDaoImpl.getInstance().addRoom(b2.getBuildingName(), r2);
//		
//		Room r3 = new Room("203B");
//		LocationDaoImpl.getInstance().addRoom(b2.getBuildingName(), r3);
//		
//		Room r4 = new Room("314C");
//		LocationDaoImpl.getInstance().addRoom(b3.getBuildingName(), r4);
//		
//		Room r5 = new Room("447C");
//		LocationDaoImpl.getInstance().addRoom(b3.getBuildingName(), r5);
//		
//		Room r6 = new Room("487C");
//		LocationDaoImpl.getInstance().addRoom(b3.getBuildingName(), r6);
		
		
		
		
		//Selects all Locations from database
//		List<Location> allLocations = LocationDaoImpl.getInstance().selectAllLocations();
//		for (Location l : allLocations) {
//			System.out.println("Location: " + l.getLocationName());
//			for (Building b : l.getBuildings()) {
//				System.out.println("Building: " + b.getBuildingName());
//				for (Room r : b.getRooms()) {
//					System.out.println("Room: " + r.getRoomNumber());
//				}
//			}
//		}

		
		
		//testing Building bidirectional relationships
//		List<Building> allBuildings = LocationDaoImpl.getInstance().selectAllBuildings();
//		for (Building b : allBuildings) {
//			System.out.println(b.getBuildingName()+ ": " + b.getLocation().getLocationName());
//		}
		
		
		//testing Room relationship
//		List<Room> allRooms = LocationDaoImpl.getInstance().selectAllRooms();
//		for (Room r : allRooms) {
//			System.out.println("Room: " + r.getRoomNumber() + ", Building: " + r.getBuilding().getBuildingName());
//		}
		
		
		
//		Curriculum c = new Curriculum("JTA Automation");
//		CurriculumDaoImpl.getInstance().insertCurriculum(c);
//		
//		Skill s1 = new Skill("SQL");
//		SkillDaoImpl.getInstance().insertSkill(s1);
//		Skill s2 = new Skill("JavaScript");
//		SkillDaoImpl.getInstance().insertSkill(s2);
//		Skill s3 = new Skill("Core Java");
//		SkillDaoImpl.getInstance().insertSkill(s3);
//		Skill s4 = new Skill("Servlets");
//		SkillDaoImpl.getInstance().insertSkill(s4);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s1);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s2);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s3);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s4);
		
		
		
		//Selects all Curricula from database
//		List<Curriculum> curriculumList = CurriculumDaoImpl.getInstance().selectAllCurriculum();
//		for (Curriculum c : curriculumList) {
//			System.out.println("Curriculum: " + c.getCurriculumName());
//			for (Skill s : c.getCurriculumSkill()) {
//				System.out.println("Skill: " + s.getSkillName());
//			}
//		}
		
		
		
		
//		Skill s1 = SkillDaoImpl.getInstance().selectSkill("Core Java");
//		Skill s2 = SkillDaoImpl.getInstance().selectSkill("SQL");
//		Skill s4 = new Skill("Hibernate");
//		SkillDaoImpl.getInstance().insertSkill(s4);
//		Skill s5 = new Skill("Angular");
//		SkillDaoImpl.getInstance().insertSkill(s5);
//		Skill s6 = new Skill("Bootstrap");
//		SkillDaoImpl.getInstance().insertSkill(s6);
//		Skill s7 = new Skill("TestNG");
//		SkillDaoImpl.getInstance().insertSkill(s7);
//		Skill s8 = new Skill("jUnit");
//		SkillDaoImpl.getInstance().insertSkill(s8);
//		Skill s9 = new Skill("Protractor");
//		SkillDaoImpl.getInstance().insertSkill(s9);
		
		
		
		//ToDo: Add skills to trainers: Complete
		
		
		
		
		
//		Trainer t1 = new Trainer("Alex", "Smith");
//		TrainerDaoImpl.getInstance().insertTrainer(t1);
//		
//		Trainer t2 = new Trainer("Max", "Adams");
//		TrainerDaoImpl.getInstance().insertTrainer(t2);
//		
//		Trainer t3 = new Trainer("John", "Stevens");
//		TrainerDaoImpl.getInstance().insertTrainer(t3);
		
//		SkillDaoImpl.getInstance().insertSkill(new Skill("C++"));
//		SkillDaoImpl.getInstance().insertSkill(new Skill("Ruby On Rails"));
//		SkillDaoImpl.getInstance().insertSkill(new Skill("CSS"));
//		SkillDaoImpl.getInstance().insertSkill(new Skill("Android Wear"));
		
//		SkillDaoImpl.getInstance().insertSkill(new Skill("Python"));
//		SkillDaoImpl.getInstance().insertSkill(new Skill("jQuery"));
//		SkillDaoImpl.getInstance().insertSkill(new Skill("JBehave"));
//		SkillDaoImpl.getInstance().insertSkill(new Skill("PHP"));
		
//		List<Skill> allSkills = SkillDaoImpl.getInstance().selectAllSkills();
//		System.out.println("Total Current Skills: " + allSkills.size());
//		
//		
//		Skill s1 = allSkills.get(0);	//Google Maps API
//		Skill s2 = allSkills.get(1);	//Advanced UI
//		Skill s3 = allSkills.get(2);	//Core Java
//		Skill s4 = allSkills.get(3);	//Services
//		Skill s5 = allSkills.get(4);	//SQL
//		Skill s6 = allSkills.get(5);	//JavaScript
//		Skill s7 = allSkills.get(6);	//Core Java
//		Skill s8 = allSkills.get(7);	//Servlets
//		Skill s9 = allSkills.get(8);	//Hibernate
//		Skill s10 = allSkills.get(9);	//Angular
//		Skill s11 = allSkills.get(10);	//Bootstrap
//		Skill s12 = allSkills.get(11);	//TestNG
//		Skill s13 = allSkills.get(12);	//jUnit
//		Skill s14 = allSkills.get(13);	//Protractor
//		Skill s15 = allSkills.get(14);	//Ruby on Rails
//		Skill s16 = allSkills.get(15);	//CSS
//		Skill s17 = allSkills.get(16);	//C++
//		Skill s18 = allSkills.get(17);	//Android Wear
		
		//Adds Skills
//		//For Trainer t1 = new Trainer("Alex", "Smith");
//		TrainerDaoImpl.getInstance().addSkill(t1.getTrainerFirstName(), t1.getTrainerLastName(), s3);
//		TrainerDaoImpl.getInstance().addSkill(t1.getTrainerFirstName(), t1.getTrainerLastName(), s5);
//		TrainerDaoImpl.getInstance().addSkill(t1.getTrainerFirstName(), t1.getTrainerLastName(), s6);
//		TrainerDaoImpl.getInstance().addSkill(t1.getTrainerFirstName(), t1.getTrainerLastName(), s7);
//		TrainerDaoImpl.getInstance().addSkill(t1.getTrainerFirstName(), t1.getTrainerLastName(), s8);
//		TrainerDaoImpl.getInstance().addSkill(t1.getTrainerFirstName(), t1.getTrainerLastName(), s10);
//		
//		//Adds Skills	
// 		//For Trainer t2 = new Trainer("Max", "Adams");
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s3);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s5);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s6);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s7);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s8);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s10);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s11);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s12);
//		TrainerDaoImpl.getInstance().addSkill(t2.getTrainerFirstName(), t2.getTrainerLastName(), s14);
//		
//			//Adds skills 
//			//For Trainer t2 = new Trainer("John", "Stevens");
//		TrainerDaoImpl.getInstance().addSkill(t3.getTrainerFirstName(), t3.getTrainerLastName(), s1);
//		TrainerDaoImpl.getInstance().addSkill(t3.getTrainerFirstName(), t3.getTrainerLastName(), s2);
//		TrainerDaoImpl.getInstance().addSkill(t3.getTrainerFirstName(), t3.getTrainerLastName(), s3);
//		TrainerDaoImpl.getInstance().addSkill(t3.getTrainerFirstName(), t3.getTrainerLastName(), s4);
//		TrainerDaoImpl.getInstance().addSkill(t3.getTrainerFirstName(), t3.getTrainerLastName(), s6);
//		TrainerDaoImpl.getInstance().addSkill(t3.getTrainerFirstName(), t3.getTrainerLastName(), s9);
//		TrainerDaoImpl.getInstance().addSkill(t3.getTrainerFirstName(), t3.getTrainerLastName(), s14);
		
		
		//Selects all Trainers and displays each of their skills
//		List<Trainer> allTrainers = TrainerDaoImpl.getInstance().selectAllTrainers();
//		for (Trainer t : allTrainers) {
//			System.out.println("Trainer: " + t.getTrainerFirstName() + " " + t.getTrainerLastName());
//			for (Skill s : t.getTrainerSkill()) {
//				System.out.print;ln(s.getSkillName());
//			}
//		}
		
		
		
		//ToDo: Add skills to Focuses
//		Focus f1 = new Focus("Android Programming");
//		FocusDaoImpl.getInstance().insertFocus(f1);
//		Focus f2 = new Focus("Embedded Systems");
//		FocusDaoImpl.getInstance().insertFocus(f2);
//		Focus f3 = new Focus("Web Development");
//		FocusDaoImpl.getInstance().insertFocus(f3);
//		
//		FocusDaoImpl.getInstance().addSkill(f1.getFocusName(), s1);
//		FocusDaoImpl.getInstance().addSkill(f1.getFocusName(), s2);
//		FocusDaoImpl.getInstance().addSkill(f1.getFocusName(), s8);
//		
//		FocusDaoImpl.getInstance().addSkill(f2.getFocusName(), s14);
//		
//		FocusDaoImpl.getInstance().addSkill(f3.getFocusName(), s16);
//		FocusDaoImpl.getInstance().addSkill(f3.getFocusName(), s17);
		
		
		

//		List<Focus> allFocuses = FocusDaoImpl.getInstance().selectAllFocuses();
//		for (Focus f : allFocuses) {
//			if (f.getFocusSkill().size() > 0) {
//				System.out.println("Focus: " + f.getFocusId() + " - " + f.getFocusName());
//				for (Skill s : f.getFocusSkill()) {
//					System.out.println(s.getSkillName());
//				}
//			}
//		}
		
//		Focus focus = FocusDaoImpl.getInstance().selectFocusByName("Wildcard");
//		Skill s1 = SkillDaoImpl.getInstance().selectSkill("Python");
//		FocusDaoImpl.getInstance().addSkill(focus.getFocusName(), s1);
//		Skill s2 = SkillDaoImpl.getInstance().selectSkill("PHP");
//		FocusDaoImpl.getInstance().addSkill(focus.getFocusName(), s2);
//		Skill s3 = SkillDaoImpl.getInstance().selectSkill("jQuery");
//		FocusDaoImpl.getInstance().addSkill(focus.getFocusName(), s3);
//		Skill s4 = SkillDaoImpl.getInstance().selectSkill("JBehave");
//		FocusDaoImpl.getInstance().addSkill(focus.getFocusName(), s4);
		
		
//		Batch batch = new Batch("141AllAround");
//		BatchDaoImpl.getInstance().createBatch(batch);
//		
//		//ToDo: Batch relationships
//		Batch b1 = BatchDaoImpl.getInstance().selectBatchByName("141AllAround");
//		Room r1 = LocationDaoImpl.getInstance().selectRoomByName("B3");
//		Trainer t1 = TrainerDaoImpl.getInstance().selectTrainerByName("Alex", "Smith");
//		Curriculum c1 = CurriculumDaoImpl.getInstance().selectCurriculumByName("Entrepenuer");
//		Focus f1 = FocusDaoImpl.getInstance().selectFocusByName("Wildcard");
//		
//		BatchDaoImpl.getInstance().addRoomToBatch(b1.getBatchName(), r1);
//		BatchDaoImpl.getInstance().addTrainerToBatch(b1.getBatchName(), t1);
//		BatchDaoImpl.getInstance().addCurriculumToBatch(b1.getBatchName(), c1);
//		BatchDaoImpl.getInstance().addFocusToBatch(b1.getBatchName(), f1);
		
		
//		Curriculum curriculum = new Curriculum("Entrepenuer");
//		CurriculumDaoImpl.getInstance().insertCurriculum(curriculum);
//		Skill s1 = SkillDaoImpl.getInstance().selectSkill("Core Java");
//		CurriculumDaoImpl.getInstance().addSkill(curriculum.getCurriculumName(), s1);
//		Skill s2 = SkillDaoImpl.getInstance().selectSkill("SQL");
//		CurriculumDaoImpl.getInstance().addSkill(curriculum.getCurriculumName(), s2);
//		Skill s3 = SkillDaoImpl.getInstance().selectSkill("Hibernate");
//		CurriculumDaoImpl.getInstance().addSkill(curriculum.getCurriculumName(), s3);
//		Skill s4 = SkillDaoImpl.getInstance().selectSkill("Ruby on Rails");
//		CurriculumDaoImpl.getInstance().addSkill(curriculum.getCurriculumName(), s4);
//		Skill s5 = SkillDaoImpl.getInstance().selectSkill("Servlets");
//		CurriculumDaoImpl.getInstance().addSkill("Entrepenuer", s5);
		
		
		
		List<Batch> allBatches = BatchDaoImpl.getInstance().selectAllBatches();
		for (Batch b : allBatches) {
			System.out.println("Batch: " + b.getBatchName());
			System.out.println("Room: "+b.getRoom().getRoomNumber());
			System.out.println("Building: "+ b.getRoom().getBuilding().getBuildingName());
			System.out.println("Location: " + b.getRoom().getBuilding().getLocation().getLocationName());
			System.out.println("Trainer: " + b.getTrainer().getTrainerFirstName() + " " + b.getTrainer().getTrainerLastName());
			for (Skill s : b.getTrainer().getTrainerSkill()) {
				System.out.println("Trainer Skill: " + s.getSkillName());
			}
			System.out.println("Curriculum: " + b.getCurriculum().getCurriculumName());
			for (Skill s : b.getCurriculum().getCurriculumSkill()) {
				System.out.println("Curriculum Skill: " + s.getSkillName());
			}
			System.out.println("Focus: " + b.getFocus().getFocusName());
			for (Skill s : b.getFocus().getFocusSkill()) {
				System.out.println("Focus Skill: " + s.getSkillName());
			}
		}
		
	

		
		
		HibernateUtil.shutdown();
		
		//ToDo: Insert enough data and be able to pull each one accordingly
		
		
		
		
		
	}
	
}

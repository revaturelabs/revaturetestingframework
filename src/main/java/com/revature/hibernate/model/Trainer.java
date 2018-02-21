package com.revature.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {

	

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="trainer_seq")
		@SequenceGenerator(name="trainer_seq", allocationSize=1, initialValue=1)
		@Column(name="trainer_id", nullable=false, updatable=false)
		private int trainerId;
		
		@Column(name="trainer_firstname", nullable=false, updatable=true, length=20)
		private String trainerFirstName;
		
		@Column(name="trainer_lastname", nullable=false, updatable=true, length=20)
		private String trainerLastName;
		
		
		@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinTable(name="trainer_skill", joinColumns= {@JoinColumn(name="trainer_id")},
		inverseJoinColumns= {@JoinColumn(name="skill_id")})
		@ElementCollection(targetClass=Skill.class)
		private Set<Skill> trainerSkill;


		public Trainer() {
			super();
		}


		public Trainer(String trainerFirstName, String trainerLastName) {
			super();
			this.trainerFirstName = trainerFirstName;
			this.trainerLastName = trainerLastName;
		}


		public Trainer(String trainerFirstName, String trainerLastName, Set<Skill> trainerSkill) {
			super();
			this.trainerFirstName = trainerFirstName;
			this.trainerLastName = trainerLastName;
			this.trainerSkill = trainerSkill;
		}


		public Trainer(int trainerId, String trainerFirstName, String trainerLastName, Set<Skill> trainerSkill) {
			super();
			this.trainerId = trainerId;
			this.trainerFirstName = trainerFirstName;
			this.trainerLastName = trainerLastName;
			this.trainerSkill = trainerSkill;
		}


		public int getTrainerId() {
			return trainerId;
		}

		public String getTrainerFirstName() {
			return trainerFirstName;
		}


		public void setTrainerFirstName(String trainerFirstName, String trainerLastName) {
			this.trainerFirstName = trainerFirstName;
		}


		public String getTrainerLastName() {
			return trainerLastName;
		}


		public void setTrainerLastName(String trainerLastName) {
			this.trainerLastName = trainerLastName;
		}


		public Set<Skill> getTrainerSkill() {
			return trainerSkill;
		}


		public void setTrainerSkill(Set<Skill> trainerSkill) {
			this.trainerSkill = trainerSkill;
		}


		@Override
		public String toString() {
			return "Trainer [trainerId=" + trainerId + ", trainerFirstName=" + trainerFirstName + ", trainerLastName=" +trainerLastName + "]";
		}
		
		
}

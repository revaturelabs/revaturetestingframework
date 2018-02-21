package com.revature.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="skill_seq")
	@SequenceGenerator(name="skill_seq", allocationSize=1, initialValue=1)
	@Column(name="skill_id", nullable=false, updatable=false)
	private int skillId;
	
	@Column(name="skill_name", nullable=false, updatable=false, unique=false)
	private String skillName;
	
//	@ManyToMany(mappedBy="focusSkill")
//	private Collection<Focus> skillFocus = new ArrayList<Focus>();
	
//	@ManyToMany(mappedBy="curriculumSkill")
//	private Collection<Curriculum> skillCurriculum = new ArrayList<Curriculum>();
	
//	@ManyToMany(fetch=FetchType.LAZY, mappedBy="trainerSkill")
//	@ElementCollection(targetClass=Trainer.class)
//	private List<Trainer> skillTrainer = new ArrayList<Trainer>();

	public Skill() {
		super();
	}

	public Skill(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}
	
	public Skill(String name) {
		this.skillName = name;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	
//	public Collection<Curriculum> getSkillCurriculum() {
//		return skillCurriculum;
//	}
//
//	public void setSkillCurriculum(Collection<Curriculum> skillCurriculum) {
//		this.skillCurriculum = skillCurriculum;
//	}

//	public List<Trainer> getSkillTrainer() {
//		return skillTrainer;
//	}
//
//	public void setSkillTrainer(List<Trainer> skillTrainer) {
//		this.skillTrainer = skillTrainer;
//	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	
}

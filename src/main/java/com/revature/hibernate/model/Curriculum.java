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
@Table(name="curriculum")
public class Curriculum {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="curriculum_seq")
	@SequenceGenerator(name="curriculum_seq", allocationSize=1, initialValue=1)
	@Column(name="curriculum_id", nullable=false, updatable=false)
	private int curriculumId;
	
	@Column(name="curriculum_name", nullable=false, updatable=true, length=20)
	private String curriculumName;
	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="curriculum_skill", joinColumns=@JoinColumn(name="curriculum_id"),
	inverseJoinColumns=@JoinColumn(name="skill_id"))
	@ElementCollection(targetClass=Skill.class)
	private Set<Skill> curriculumSkill;

	
	
	//No args constructor
	public Curriculum() {
		super();
	}
	
	//Curricumum Name Constructor
	public Curriculum(String name) {
		this.curriculumName = name;
	}
	
	//All args constructor
	public Curriculum(int curriculumId, String curriculumName, Set<Skill> curriculumSkill) {
	super();
	this.curriculumId = curriculumId;
	this.curriculumName = curriculumName;
	this.curriculumSkill = curriculumSkill;
	}
	
	
	//Getters and setters
	public int getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(int curriculumId) {
		this.curriculumId = curriculumId;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public Set<Skill> getCurriculumSkill() {
		return curriculumSkill;
	}

	public void setCurriculumSkill(Set<Skill> curriculumSkill) {
		this.curriculumSkill = curriculumSkill;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Curriculum [curriculumId=" + curriculumId + ", curriculumName=" + curriculumName + "]";
	}
	
	
	
}

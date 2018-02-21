package com.revature.hibernate.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUILDING")
public class Building {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="building_seq")
	@SequenceGenerator(name="building_seq", allocationSize=1, initialValue=1)
	@Column(name="BUILDING_ID", nullable=false, updatable=false)
	private int buildingId;
	
	
	@Column(name="BUILDING_NAME", nullable=false, updatable=true)
	private String buildingName;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private Location location;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="BUILDING_ROOM", joinColumns=@JoinColumn(name="BUILDING_ID"), inverseJoinColumns=@JoinColumn(name="ROOM_ID"))
	private Set<Room> rooms;

	public Building() {
		super();
	}
	
	public Building(int id) {
		this.buildingId = id;
	}
	
	public Building(String name) {
		this.buildingName = name;
	}
	
	public Building(int id, String name) {
		this.buildingId = id;
		this.buildingName = name;
	}
	
	
	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", buildingName=" + buildingName + ", location=" + location
				+"]";
	}
	
	
	
}

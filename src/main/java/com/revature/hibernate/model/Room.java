package com.revature.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_seq")
	@SequenceGenerator(name="room_seq", allocationSize=1, initialValue=1)
	@Column(name="ROOM_ID", nullable=false, updatable=false)
	private int roomId;
	
	//Room number is a string to incorporate 
	@Column(name="ROOM_NUMBER", nullable=false, updatable=true, length = 20)
	private String roomNumber;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Building building;
	
	
	public Room() {
		super();
		
	}
	
	public Room(int id) {
		this.roomId = id;
	}
	
	public Room(String number) {
		this.roomNumber = number;
	}
	
	public Room(int id, String number) {
		this.roomId = id;
		this.roomNumber = number;
	}


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public String getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Building getBuilding() {
		return building;
	}


	public void setBuilding(Building building) {
		this.building = building;
	}

	public String getBuildingName() {
		return this.getBuilding().getBuildingName();
	}

	public String getLocationName() {
		return this.getBuilding().getLocation().getLocationName();
	}
	
	public String getLocationCity() {
		return this.getBuilding().getLocation().getLocationCity();
	}
	
	public String getLocationState() {
		return this.getBuilding().getLocation().getLocationState();
	}
	
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", building=" + building + "]";
	}
	
	
	
}

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location_seq")
	@SequenceGenerator(name="location_seq", allocationSize=1, initialValue=1)
	@Column(name="LOCATION_ID", nullable=false, updatable=false)
	private int locationId;
	
	@Column(name="LOCATION_NAME", nullable=false, updatable=true, length=20)
	private String locationName;
	
	@Column(name="LOCATION_CITY", nullable=false, updatable=true, length=20)
	private String locationCity;
	
	@Column(name="LOCATION_STATE", nullable=false, updatable=true, length=20)
	private String locationState;
	
	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinTable(name="LOCATION_BUILDING", joinColumns=@JoinColumn(name="LOCATION_ID"), inverseJoinColumns=@JoinColumn(name="BUILDING_ID"))
	private Set<Building> buildings;
	

	public Location() {
		super();
	}

	public Location(int locationId) {
		super();
		this.locationId = locationId;
	}

	
	
	public Location(String locationName, String locationCity, String locationState) {
		super();
		this.locationName = locationName;
		this.locationCity = locationCity;
		this.locationState = locationState;
	}

	public Location(int locationId, String locationName, String locationCity, String locationState) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationCity = locationCity;
		this.locationState = locationState;
	}
	

	public Location(int locationId, String locationName, String locationCity, String locationState,
			Set<Building> buildings) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationCity = locationCity;
		this.locationState = locationState;
		this.buildings = buildings;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public Set<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", locationCity="
				+ locationCity + ", locationState=" + locationState +"]";
	}

	

	
	
	
}

package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Building;
import com.revature.hibernate.model.Location;
import com.revature.hibernate.model.Room;

public interface LocationDao {

	void insertLocation(Location location);
	Location selectLocationById(int id);
	Location selectLocationByName(String name);
	int getLocationIdByName(String name);
	void updateLocation(int id, String locationName, String locationCity, String locationState);
	List<Location> selectAllLocations();
	List<Building> selectAllBuildings();
	List<Room> selectAllRooms();
	void deleteLocation(String name);
	void addBuilding(String locationName, Building building);
	void addRoom(String buildingName, Room room);
	Room selectRoomByName(String room);
	Building selectBuildingByName(String name);
	
}

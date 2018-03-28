package com.revature.test.utils;

public class Associate {
	private  int associateId=1;
	private  String firstName;
	private  String lastName;
	private  String marketStatus;
	private  String clientName;
	private String batchName;
/*
 * associate class 	
 */ public Associate() {
		  }
/**
 * @param associatId
 * @param firstName
 * @param lastName
 * @param marketStatus
 * @param clientName
 * @param batchName
 */
public Associate(int associateId, String firstName, String lastName, String marketStatus, String clientName,
		String batchName) {
	super();
	this.associateId = associateId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.marketStatus = marketStatus;
	this.clientName = clientName;
	this.batchName = batchName;
}
	
public Associate (int associateId, String firstName, String lastName) {
	this.associateId = associateId;
	this.firstName = firstName;
	this.lastName = lastName;
}
public int getAssociateId() {
	return associateId;
}
public void setAssociateId(int associateId) {
	this.associateId = associateId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getMarketStatus() {
	return marketStatus;
}
public void setMarketStatus(String marketStatus) {
	this.marketStatus = marketStatus;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getBatchName() {
	return batchName;
}
public void setBatchName(String batchName) {
	this.batchName = batchName;
}
@Override
public String toString() {
	return "Associate [associateId=" + associateId + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", marketStatus=" + marketStatus + ", clientName=" + clientName + ", batchName=" + batchName + "]";
}

}

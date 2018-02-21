package com.revature.servlets;

public class TestObject {
	private int id;
	private String name;
	private String status;
	private String belongsToClass;	
	private Throwable exceptionThrown;
	
	public TestObject() {}
	
	public TestObject(int id, String name, String status, String btclass, Throwable exceptionThrown) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.belongsToClass = btclass;
		this.exceptionThrown = exceptionThrown;
	}
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBelongsToClass() {
		return belongsToClass;
	}
	public void setBelongsToClass(String belongsToClass) {
		this.belongsToClass = belongsToClass;
	}
	public Throwable getExceptionThrown() {
		return exceptionThrown;
	}
	public void setExceptionThrown(Throwable exceptionThrown) {
		this.exceptionThrown = exceptionThrown;
	}
	
	@Override
	public String toString() {
		return "TestObject [id=" + id + ", name=" + name + ", status=" + status + ", belongsToClass=" + belongsToClass
				+ ", exceptionThrown=" + exceptionThrown + "]";
	}
}

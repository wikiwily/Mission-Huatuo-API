package com.hase.huatuo.healthcheck.model;

public class PersonHealthInfo {
	private String staffID;
	private String staffName;
	private String healthState; 
	private String local;
	private String building;
	
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getHealthState() {
		return healthState;
	}
	public void setHealthState(String healthState) {
		this.healthState = healthState;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	
}
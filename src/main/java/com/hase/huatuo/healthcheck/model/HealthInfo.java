package com.hase.huatuo.healthcheck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
public class HealthInfo {
	@Column(name="open_Id")
	private String openId;
	@Id
	@Column(name="staff_Id")
	private String staffID;
	@Column(name="mobile_Num")
	private String mobileNum;
	@Column(name="department")
	private String department;
	@Column(name="city")
	private String city;
	@Id
	@Column(name="workplace")
	private String workplace;
	@Column(name="health_Status")
	private String healthStatus;
	@Column(name="reporter")
	private String reporter;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
}

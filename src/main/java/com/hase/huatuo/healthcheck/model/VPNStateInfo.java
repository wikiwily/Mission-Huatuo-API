package com.hase.huatuo.healthcheck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="vpn_info")
public class VPNStateInfo {
	@Id
	@Column
	private String staffId;
	@Column
	private String openId;
	@Column
	private String havePC;
	@Column
	private String haveToken;
	@Column
	private String vpnType;
	@Column
	private String other;
	@Column
	private String vpnLocal;
	@Column
	private String vpnState;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getHavePC() {
		return havePC;
	}

	public void setHavePC(String havePC) {
		this.havePC = havePC;
	}

	public String getHaveToken() {
		return haveToken;
	}

	public void setHaveToken(String haveToken) {
		this.haveToken = haveToken;
	}

	public String getVpnType() {
		return vpnType;
	}

	public void setVpnType(String vpnType) {
		this.vpnType = vpnType;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getVpnLocal() {
		return vpnLocal;
	}

	public void setVpnLocal(String vpnLocal) {
		this.vpnLocal = vpnLocal;
	}

	public String getVpnState() {
		return vpnState;
	}

	public void setVpnState(String vpnState) {
		this.vpnState = vpnState;
	}
}

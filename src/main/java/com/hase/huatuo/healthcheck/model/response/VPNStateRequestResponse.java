package com.hase.huatuo.healthcheck.model.response;

import java.util.List;

import com.hase.huatuo.healthcheck.model.VPNStateInfo;

public class VPNStateRequestResponse {
	private List<VPNStateInfo> vpnStateInfos;

	public List<VPNStateInfo> getVpnStateInfos() {
		return vpnStateInfos;
	}

	public void setVpnStateInfos(List<VPNStateInfo> vpnStateInfos) {
		this.vpnStateInfos = vpnStateInfos;
	}
	
	
}

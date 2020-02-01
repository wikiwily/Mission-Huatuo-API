package com.hase.huatuo.healthcheck.model.request;

import com.hase.huatuo.healthcheck.model.VPNStateInfo;
import lombok.Data;

public class VPNStatePostBody {
	private VPNStateInfo vpnStateInfo;

	public VPNStateInfo getVpnStateInfo() {
		return vpnStateInfo;
	}

	public void setVpnStateInfo(VPNStateInfo vpnStateInfo) {
		this.vpnStateInfo = vpnStateInfo;
	}
}

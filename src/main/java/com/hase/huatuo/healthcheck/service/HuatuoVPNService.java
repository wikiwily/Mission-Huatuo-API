package com.hase.huatuo.healthcheck.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hase.huatuo.healthcheck.model.VPNStateInfo;
import com.hase.huatuo.healthcheck.model.request.HealthRequest;
import com.hase.huatuo.healthcheck.model.request.VPNStatePostBody;
import com.hase.huatuo.healthcheck.model.response.VPNStatePostResponse;
import com.hase.huatuo.healthcheck.model.response.VPNStateRequestResponse;

@Service
public class HuatuoVPNService {

	public VPNStatePostResponse setVPNState(VPNStatePostBody vpnStatePostBody) {
		VPNStatePostResponse reponse = new VPNStatePostResponse();
		reponse.setErrorCode("000");
		return reponse;
	}
	
	public VPNStateRequestResponse getVPNState(HealthRequest healthRequest) {
		VPNStateRequestResponse reponse = new VPNStateRequestResponse();
		
		List<VPNStateInfo> vpnStateInfos = new ArrayList<VPNStateInfo>();
		VPNStateInfo info = new VPNStateInfo();
		info.setVpnLocal("CN");
		info.setVpnState("good");
		
		vpnStateInfos.add(info);
		reponse.setVpnStateInfos(vpnStateInfos);
		return reponse;
	}
}

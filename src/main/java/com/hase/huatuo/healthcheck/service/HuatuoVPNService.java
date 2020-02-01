package com.hase.huatuo.healthcheck.service;

import com.hase.huatuo.healthcheck.dao.VPNInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hase.huatuo.healthcheck.model.VPNStateInfo;
import com.hase.huatuo.healthcheck.model.request.VPNStatePostBody;
import com.hase.huatuo.healthcheck.model.response.VPNStatePostResponse;

@Service
public class HuatuoVPNService {

	@Autowired
	private VPNInfoRepository vpnInfoRepository;

	public VPNStatePostResponse setVPNState(VPNStatePostBody vpnStatePostBody) {
		VPNStateInfo vpnStateInfo = vpnStatePostBody.getVpnStateInfo();
		vpnInfoRepository.saveAndFlush(vpnStateInfo);
		VPNStatePostResponse response = new VPNStatePostResponse();
		response.setErrorCode("000");
		return response;
	}
}

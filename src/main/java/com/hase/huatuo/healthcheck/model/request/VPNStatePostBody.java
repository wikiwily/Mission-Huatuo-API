package com.hase.huatuo.healthcheck.model.request;

import com.hase.huatuo.healthcheck.model.VPNStateInfo;
import lombok.Data;

@Data
public class VPNStatePostBody {
	private VPNStateInfo vpnStateInfo;
}

package com.hase.huatuo.healthcheck.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hase.huatuo.healthcheck.model.request.HealthPostBody;
import com.hase.huatuo.healthcheck.model.request.HealthRequest;
import com.hase.huatuo.healthcheck.model.request.VPNStatePostBody;
import com.hase.huatuo.healthcheck.model.response.HealthPostResponse;
import com.hase.huatuo.healthcheck.model.response.HealthRequestResponse;
import com.hase.huatuo.healthcheck.model.response.VPNStatePostResponse;
import com.hase.huatuo.healthcheck.model.response.VPNStateRequestResponse;
import com.hase.huatuo.healthcheck.service.HuatuoHealthService;
import com.hase.huatuo.healthcheck.service.HuatuoVPNService;


@RestController
@RequestMapping({"/api","/api/v1"})
public class HuatuoResource {

    @Autowired
    private HuatuoHealthService huatuoHealthService;
    @Autowired
    private HuatuoVPNService huatuoVPNService;

    
    @PostMapping("/health")
    public HealthPostResponse updateHealth(@RequestBody final HealthPostBody healthPostBody) {
    	
    	return huatuoHealthService.setPersonHealth(healthPostBody);
    }
    
    @GetMapping("/health")
    public HealthRequestResponse requestHealth(final HealthRequest healthRequest) {
    	
    	return huatuoHealthService.getPersonHealth(healthRequest);
    }
    
    @PostMapping("/vpnstate")
    public VPNStatePostResponse updateVPNState(@RequestBody final VPNStatePostBody vpnStatePostBody) {
    	
    	return huatuoVPNService.setVPNState(vpnStatePostBody);
    }
    
    @GetMapping("/vpnstate")
    public VPNStateRequestResponse requestVPNState(final HealthRequest healthRequest) {
    	
    	return huatuoVPNService.getVPNState(healthRequest);
    }
    
}

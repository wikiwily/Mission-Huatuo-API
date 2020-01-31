package com.hase.huatuo.healthcheck.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hase.huatuo.healthcheck.model.request.HealthPostBody;
import com.hase.huatuo.healthcheck.model.request.HealthRequest;
import com.hase.huatuo.healthcheck.model.response.HealthPostResponse;
import com.hase.huatuo.healthcheck.model.response.HealthRequestResponse;
import com.hase.huatuo.healthcheck.model.response.PersonHealthInfo;
import com.hase.huatuo.healthcheck.service.HuatuoHealthService;
import com.hase.huatuo.healthcheck.service.HuatuoVPNService;


@RestController
@RequestMapping({"/api","/api/v1"})
public class HuatuoResource {

    @Autowired
    private HuatuoHealthService huatuoHealthService;
//    @Autowired
//    private HuatuoVPNService huatuoVPNService;

    
    @PostMapping("/health")
    public HealthPostResponse updateHealth(@RequestBody final HealthPostBody healthPostBody) {
    	
    	HealthPostResponse response = new HealthPostResponse();
    	return response;
    }
    
    @GetMapping("/health")
    public HealthRequestResponse requestHealth(final HealthRequest healthRequest) {
    	
    	return huatuoHealthService.getPersionHealth();
    }
    
    
    @GetMapping("/test")
    public String test() {
    	return "hello";
    }
}

package com.hase.huatuo.healthcheck.rest;

import java.util.List;

import com.hase.huatuo.healthcheck.model.response.AreaReport;
import com.hase.huatuo.healthcheck.service.HealthReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hase.huatuo.healthcheck.model.request.HealthPostBody;
import com.hase.huatuo.healthcheck.model.response.HealthPostResponse;
import com.hase.huatuo.healthcheck.service.HuatuoHealthService;


@RestController
@RequestMapping({"/api","/api/v1"})
public class HuatuoResource {

    @Autowired
    private HuatuoHealthService huatuoHealthService;

    @Autowired
    private HealthReportService healthReportService;
//    @Autowired
//    private HuatuoVPNService huatuoVPNService;

    
    @PostMapping("/health")
    public HealthPostResponse updateHealth(@RequestBody final HealthPostBody healthPostBody) {
    	HealthPostResponse response = new HealthPostResponse();
    	return response;
    }
    
    @GetMapping("/health")
    public ResponseEntity<List<AreaReport>> requestHealth(@RequestHeader("X-IS-DUMMY") String isDummy) {
    	return healthReportService.enquiry(isDummy);
    }
    
    
    @GetMapping("/test")
    public String test() {
    	return "hello";
    }
}

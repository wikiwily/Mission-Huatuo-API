package com.hase.huatuo.healthcheck.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hase.huatuo.healthcheck.model.PersonHealthInfo;
import com.hase.huatuo.healthcheck.model.request.HealthPostBody;
import com.hase.huatuo.healthcheck.model.request.HealthRequest;
import com.hase.huatuo.healthcheck.model.response.HealthPostResponse;
import com.hase.huatuo.healthcheck.model.response.HealthRequestResponse;

@Service
public class HuatuoHealthService {

	public HealthPostResponse setPersonHealth(HealthPostBody healthPostBody) {
		HealthPostResponse response = new HealthPostResponse();
		response.setErrorCode("000");
    	return response;
	}
	
	public HealthRequestResponse getPersonHealth(HealthRequest healthRequest) {
		HealthRequestResponse response = new HealthRequestResponse();
    	
    	PersonHealthInfo info = new PersonHealthInfo();
    	info.setStaffID("11112222");
    	info.setStaffName("aa bb");
    	info.setHealthState("good");
    	info.setLocal("GZ");
    	info.setBuilding("WeWork");
    	
    	List<PersonHealthInfo> personHealthInfos = new ArrayList<PersonHealthInfo>();
    	personHealthInfos.add(info);
    	response.setPersonHealthInfos(personHealthInfos);
    	
    	return response;
	}
}

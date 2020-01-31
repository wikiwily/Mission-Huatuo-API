package com.hase.huatuo.healthcheck.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hase.huatuo.healthcheck.model.response.HealthRequestResponse;
import com.hase.huatuo.healthcheck.model.response.PersonHealthInfo;

@Service
public class HuatuoHealthService {

	public HealthRequestResponse getPersionHealth() {
		HealthRequestResponse response = new HealthRequestResponse();
    	
    	PersonHealthInfo info = new PersonHealthInfo();
    	info.setStaffID("11112222");
    	info.setStaffName("aa bb");
    	info.setHealthState("good");
    	
    	List<PersonHealthInfo> personHealthInfos = new ArrayList<PersonHealthInfo>();
    	personHealthInfos.add(info);
    	response.setPersonHealthInfos(personHealthInfos);
    	
    	return response;
	}
}

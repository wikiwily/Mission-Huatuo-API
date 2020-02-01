package com.hase.huatuo.healthcheck.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hase.huatuo.healthcheck.dao.PersonHealthInfoRepository;
import com.hase.huatuo.healthcheck.model.HealthInfo;
import com.hase.huatuo.healthcheck.model.request.HealthPostBody;
import com.hase.huatuo.healthcheck.model.request.HealthRequest;
import com.hase.huatuo.healthcheck.model.response.HealthPostResponse;
import com.hase.huatuo.healthcheck.model.response.HealthRequestResponse;

@Service
public class HuatuoHealthService {

	@Autowired
    private PersonHealthInfoRepository recordsRepository;
	
	public HealthPostResponse setPersonHealth(HealthPostBody healthPostBody) {
		HealthPostResponse response = new HealthPostResponse();
		deleteHealthInfo(healthPostBody);
		addHealthInfo(healthPostBody);
		response.setErrorCode("000");
    	return response;
	}
	
	public void deleteHealthInfo(HealthPostBody healthPostBody) { 
		HealthInfo pi = new HealthInfo();
		pi.setStaffID(healthPostBody.getPersonHealthInfo().getStaffID());
		recordsRepository.delete(pi);
	}
	
	public void addHealthInfo(HealthPostBody healthPostBody) { 
		String workplace = healthPostBody.getPersonHealthInfo().getWorkplace();
		String[] list = workplace.split(",");
		HealthInfo pi = new HealthInfo();
		pi.setCity(healthPostBody.getPersonHealthInfo().getCity());
		pi.setDepartment(healthPostBody.getPersonHealthInfo().getDepartment());
		pi.setHealthStatus(healthPostBody.getPersonHealthInfo().getHealthStatus());
		pi.setMobileNum(healthPostBody.getPersonHealthInfo().getMobileNum());
		pi.setOpenId(healthPostBody.getPersonHealthInfo().getOpenId());
		pi.setReporter(healthPostBody.getPersonHealthInfo().getReporter());
		pi.setStaffID(healthPostBody.getPersonHealthInfo().getStaffID());
//		pi.setWorkplace(workplace);
		for (int i=0; i<list.length; i++) { 
			pi.setWorkplace(list[i]);
			recordsRepository.save(pi);
		}
		recordsRepository.flush();
	}
	
	public HealthRequestResponse getPersonHealth(HealthRequest healthRequest) {
		HealthRequestResponse response = new HealthRequestResponse();
    	
    	return response;
	}
}

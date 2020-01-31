package com.hase.huatuo.healthcheck.model.response;

import java.util.List;

import com.hase.huatuo.healthcheck.model.PersonHealthInfo;

public class HealthRequestResponse {
	private List<PersonHealthInfo> personHealthInfos;

	public List<PersonHealthInfo> getPersonHealthInfos() {
		return personHealthInfos;
	}

	public void setPersonHealthInfos(List<PersonHealthInfo> personHealthInfos) {
		this.personHealthInfos = personHealthInfos;
	}
	
}

package com.hase.huatuo.healthcheck.model.request;

import com.hase.huatuo.healthcheck.model.PersonHealthInfo;

public class HealthPostBody {
	private PersonHealthInfo personHealthInfo;

	public PersonHealthInfo getPersonHealthInfo() {
		return personHealthInfo;
	}

	public void setPersonHealthInfo(PersonHealthInfo personHealthInfo) {
		this.personHealthInfo = personHealthInfo;
	}
	
}

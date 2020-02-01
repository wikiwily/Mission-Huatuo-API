package com.hase.huatuo.healthcheck.model.request;

import com.hase.huatuo.healthcheck.model.HealthInfo;

public class HealthPostBody {
	private HealthInfo personHealthInfo;

	public HealthInfo getPersonHealthInfo() {
		return personHealthInfo;
	}

	public void setPersonHealthInfo(HealthInfo personHealthInfo) {
		this.personHealthInfo = personHealthInfo;
	}
	
}

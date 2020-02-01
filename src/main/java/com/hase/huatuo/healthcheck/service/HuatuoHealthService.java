package com.hase.huatuo.healthcheck.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Service;

import com.hase.huatuo.healthcheck.dao.PersonHealthInfoRepository;
import com.hase.huatuo.healthcheck.model.HealthInfo;
import com.hase.huatuo.healthcheck.model.healthPK;
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
		try {
			deleteHealthInfo(healthPostBody);
//			deleteHealthInfoHql(healthPostBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		addHealthInfo(healthPostBody);
		response.setErrorCode("000");
		return response;
	}

	public void deleteHealthInfoHql(HealthPostBody healthPostBody) {
		Transaction tx = null;
//		try {
//			SessionBuilder sb = SessionFactoryUtils.
//			Session session = sb.connection(connection).openSession();
//			Session session = SessionFactoryUtils.openSession();
//			tx = session.getTransaction();
//			session.beginTransaction();
//			Query query = session.createQuery("delete Student s where s.id=?");
//			query.setString(0, healthPostBody.getPersonHealthInfo().getId().getStaffID());
//			query.executeUpdate();
//			tx.commit();
//		} catch (HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
	}

	public void deleteHealthInfo(HealthPostBody healthPostBody) {
		HealthInfo pi = new HealthInfo();
		pi.setId(new healthPK());
		pi.getId().setStaffID(healthPostBody.getPersonHealthInfo().getId().getStaffID());
		pi.getId().setWorkplace("%%");
		recordsRepository.delete(pi);
	}

	public void addHealthInfo(HealthPostBody healthPostBody) {
		String workplace = healthPostBody.getPersonHealthInfo().getId().getWorkplace();
		String[] list = workplace.split(",");
		HealthInfo pi = new HealthInfo();
		pi.setId(new healthPK());
		pi.setCity(healthPostBody.getPersonHealthInfo().getCity());
		pi.setDepartment(healthPostBody.getPersonHealthInfo().getDepartment());
		pi.setHealthStatus(healthPostBody.getPersonHealthInfo().getHealthStatus());
		pi.setMobileNum(healthPostBody.getPersonHealthInfo().getMobileNum());
		pi.setOpenId(healthPostBody.getPersonHealthInfo().getOpenId());
		pi.setReporter(healthPostBody.getPersonHealthInfo().getReporter());
		pi.getId().setStaffID(healthPostBody.getPersonHealthInfo().getId().getStaffID());
//		pi.setWorkplace(workplace);
		for (int i = 0; i < list.length; i++) {
			pi.getId().setWorkplace(list[i]);
			recordsRepository.save(pi);
		}
		recordsRepository.flush();
	}

	public HealthRequestResponse getPersonHealth(HealthRequest healthRequest) {
		HealthRequestResponse response = new HealthRequestResponse();

		return response;
	}
}

package com.hase.huatuo.healthcheck.dao;

import com.hase.huatuo.healthcheck.model.PersonHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonHealthInfoRepository extends JpaRepository<PersonHealthInfo,String> {
}

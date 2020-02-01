package com.hase.huatuo.healthcheck.dao;

import com.hase.huatuo.healthcheck.model.VPNStateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VPNInfoRepository extends JpaRepository<VPNStateInfo,String> {

}

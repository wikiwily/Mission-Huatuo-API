package com.hase.huatuo.healthcheck.dao;

import com.hase.huatuo.healthcheck.Application;
import com.hase.huatuo.healthcheck.model.PersonHealthInfo;
import com.hase.huatuo.healthcheck.model.VPNStateInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class VpnInfoRepositoryTest {
    @Autowired
    private VPNInfoRepository vpnInfoRepository;

    @Test
    public void testAdd() {
        VPNStateInfo vpnStateInfo = new VPNStateInfo();
        vpnStateInfo.setStaffId("001");
        vpnInfoRepository.save(vpnStateInfo);
    }
    @Test
    public void testQuery() {
        Optional<VPNStateInfo> vpn  = vpnInfoRepository.findById("001");
        Assert.assertEquals("001",vpn.get().getStaffId());
    }
}

package com.hase.huatuo.healthcheck.dao;

import com.hase.huatuo.healthcheck.Application;
import com.hase.huatuo.healthcheck.model.HealthInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PersonHealthInfoRepositoryTest {
    @Autowired
    private PersonHealthInfoRepository personHealthInfoRepository;

    @Test
    public void testAdd() {
        HealthInfo personHealthInfo = new HealthInfo();
        personHealthInfo.setStaffID("002");
        personHealthInfoRepository.save(personHealthInfo);
    }
    @Test
    public void testQuery() {
        Optional<HealthInfo> per  = personHealthInfoRepository.findById("001");
        String staffId = per.get().getStaffID();
        Assert.assertEquals("001",staffId);
    }
}

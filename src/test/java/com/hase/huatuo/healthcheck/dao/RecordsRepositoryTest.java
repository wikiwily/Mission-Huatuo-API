package com.hase.huatuo.healthcheck.dao;

import com.hase.huatuo.healthcheck.Application;
import com.hase.huatuo.healthcheck.model.PersonHealthInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RecordsRepositoryTest {
    @Autowired
    private RecordsRepository recordsRepository;

    @Test
    public void testQuery() {
        PersonHealthInfo personHealthInfo = new PersonHealthInfo();
        personHealthInfo.setStaffID("001");
        recordsRepository.save(personHealthInfo);
    }
}

package com.kwit.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.model.RecordConsumption;
import com.kwit.service.RecordConsumptionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class RecordConsumptionTest extends AbstractJUnit4SpringContextTests{
	@Resource
	protected RecordConsumptionService recordConsumptionService;
	
	@Test
	public void getRecordConsumptionTest(){
		List<RecordConsumption> list=recordConsumptionService.getRecordConsumption("123456");
		for(RecordConsumption a:list){
			System.out.println(a);
		}
	}

}

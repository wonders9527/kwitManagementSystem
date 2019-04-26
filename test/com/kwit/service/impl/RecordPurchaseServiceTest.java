package com.kwit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.RecordPurchase;
import com.kwit.service.RecordPurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class RecordPurchaseServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Resource
	protected RecordPurchaseService recordPurchaseService;
	
	RecordPurchase t=new RecordPurchase();
	
	@Test
	public void getAllTest(){
		List<RecordPurchase> list=recordPurchaseService.getPurchase("000");
		System.out.println(list);
	}

}

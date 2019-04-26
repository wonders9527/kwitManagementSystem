package com.kwit.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.DataRechargeInformation;
import com.kwit.service.DataRechargeInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataRechargeInformationTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataRechargeInformationService dataRechargeInformationService;
	
	DataRechargeInformation t=new DataRechargeInformation();
	
	@Test
	public void getRechargeTest(){
		
		List<DataRechargeInformation> list=dataRechargeInformationService.getRecharge("123");
		System.out.println(list);
	}
	
	@Test
	public void saveRechargeTest(){
		t.setSocialCreditCode("123456");
		t.setStoreName("456789");
		Map<String, String> list=dataRechargeInformationService.saveRecharge(t);
		System.out.println(list);
	}
	
	@Test
	public void updateRechargeTest(){
		t.setId(1);
		t.setSocialCreditCode("ceshi");
		t.setStoreName("456789");
		Map<String, String> list=dataRechargeInformationService.updateRecharge(t);
		System.out.println(list);
	}
	
	@Test
	public void deleteRechargeTest(){
		t.setId(2);
		Map<String, String> list=dataRechargeInformationService.deleteRecharge(t);
		System.out.println(list);
	}
	
	
}

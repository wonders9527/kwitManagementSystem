package com.kwit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.DataMemberInformation;
import com.kwit.service.DataMemberInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataMemberInformationTest {
	@Resource
	protected DataMemberInformationService dataMemberInformationService;
	
	DataMemberInformation t=new DataMemberInformation();
	
	@Test
	public void getMemberInformationByPhoneTest(){
		List<DataMemberInformation> list=dataMemberInformationService.getMemberInformationByPhone("123456789111111111", "联系电话");
		for(DataMemberInformation dataClassifiedInformation:list){
			System.out.println(dataClassifiedInformation);
		}
	}
}

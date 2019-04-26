package com.kwit.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.DataMemberGrade;
import com.kwit.service.DataMemberGradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataMembershipLevelTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataMemberGradeService dataMembershipLevelService;
	
	DataMemberGrade t=new DataMemberGrade();
	
	@Test
	public void getMembershipLevelTest(){
		List<DataMemberGrade> list=dataMembershipLevelService.getMemberGrade("123456");
		System.out.print(list);
	}
	
	@Test
	public void addMembershipLevelTest(){
		t.setSocialCreditCode("123456");
		t.setStoreName("ceshi");
		t.setGradeName("456789");
		Map<String, String> list=dataMembershipLevelService.addMemberGrade(t);
		System.out.print(list);
	}
	
	@Test
	public void updateMembershipLevelTest(){
		t.setId(1);
		t.setSocialCreditCode("56789");
		t.setStoreName("ceshi");
		t.setGradeName("456789");
		Map<String, String> list=dataMembershipLevelService.updateMemberGrade(t);
		System.out.print(list);
	}
	
	@Test
	public void deleteMembershipLevelTest(){
		t.setId(1);
		Map<String, String> list=dataMembershipLevelService.deleteMemberGrade(t);
		System.out.print(list);
	}
}

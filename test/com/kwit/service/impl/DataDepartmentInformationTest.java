package com.kwit.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.model.DataDepartmentInformation;
import com.kwit.service.DataDepartmentInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataDepartmentInformationTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataDepartmentInformationService dataDepartmentInformationService;
	
	DataDepartmentInformation t=new DataDepartmentInformation();
	
	@Test
	public void getDataDepartmentTest(){
		List<DataDepartmentInformation> list=dataDepartmentInformationService.getDepartment("123456789111111111");
		System.out.println(list);
	}
	
	@Test
	public void addDataDepartmentTest(){
		t.setSocialCreditCode("01");
		t.setStoreName("01");
		t.setDepartmentName("01");
		Map<String, String> list=dataDepartmentInformationService.addDepartment(t);
		System.out.println(list);
		
	}
	
	@Test
	public void updateDataDepartmentTest(){
		t.setId(3);
		t.setSocialCreditCode("yyyyy");
		t.setStoreName("Y");
		t.setDepartmentName("Y");
		Map<String, String> list=dataDepartmentInformationService.updateDepartment(t);
		System.out.println(list);
	}
	
	@Test
	public void deleteDataDepartmentTest(){
		t.setId(3);
		System.out.println(t);
		Map<String, String> list=dataDepartmentInformationService.deleteDepartment(t);
		System.out.println(list);
	}
}

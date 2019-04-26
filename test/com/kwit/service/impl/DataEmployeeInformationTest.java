package com.kwit.service.impl;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.DataEmployeeInformation;
import com.kwit.service.DataEmployeeInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataEmployeeInformationTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataEmployeeInformationService dataEmployeeInformationService;
	
	DataEmployeeInformation t=new DataEmployeeInformation();
	
	/*
	 * 获取测试
	 */
	@Test
	public void getAllTest(){
		List<DataEmployeeInformation> list=dataEmployeeInformationService.getEmployeeInformation("123456789111111111");
		for(DataEmployeeInformation a:list){
			System.out.println(a);
		}
	}
	
	/*
	 * 增加测试
	 */
	@Test
	public void addTest(){
		SimpleDateFormat dateObj = new SimpleDateFormat("yyyy-MM-dd");
		
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		t.setCreateDate(timesTamp);
		t.setAppellation("435234");
		try {
			t.setDateBirth(dateObj.parse("2019-02-28"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t.setBirthplace("345");
		t.setContactNumber("345234");
		t.setDepartment("sdfsd");
		t.setEducation("3");
		t.setEmployeeIntroduction("34534");
		t.setEmployeeName("11111");
		t.setEmployeePicture("20190221091929_c095176ejw1e3b3snkb7dj.jpg");
		t.setEmploymentStatus("2");
		t.setGender("0");
		t.setGraduatedSchool("sdfs");
		try {
			t.setGraduatedTime(dateObj.parse("2019-02-25"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t.setHealthStatus("0");
		t.setHeight("44");
		t.setHomeAddress("dfsd");
		t.setIdNumber("4325234");
		t.setMarriageStatus("1");
		t.setPoliticalStatus("2");
		t.setPost("sdfsd");
		t.setProfession("sdfsdf");
		t.setRemark("345345");
		t.setSocialCreditCode("123456789111111111");
		t.setStoreName("门店名称");
		System.out.println(t);
		Map<String, String> list=dataEmployeeInformationService.addEmployeeInformation(t);
		System.out.println(list);
	}
	
	

}

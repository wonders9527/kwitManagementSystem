package com.kwit.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.DataSupplierInformation;
import com.kwit.service.DataSupplierInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataSupplierInformationTest {
	
	@Resource
	protected DataSupplierInformationService dataSupplierInformationService;
	
	DataSupplierInformation t=new DataSupplierInformation();
	
	@Test
	public void getSupplierInforTest(){
		List<DataSupplierInformation> list=dataSupplierInformationService.getSupplierInfor("123456");
		System.out.println(list);
	}
	
	@Test
	public void addSupplierInforTest(){
		t.setSocialCreditCode("123456789");
		t.setStoreName("001");
		t.setSupplierName("sdkfl");
		t.setSupplierCode("sdkfl");
		t.setSupplierContactNamber("sdkfl");
		t.setSupplierContactName("sdkfl");
		Map<String, String> map=dataSupplierInformationService.addSupplierInfor(t);
		System.out.println(map);
		
	}
	
	@Test
	public void updateSupplierInforTest(){
		
	}
	
	@Test
	public void deleteSupplierInforTest(){
		
	}

}

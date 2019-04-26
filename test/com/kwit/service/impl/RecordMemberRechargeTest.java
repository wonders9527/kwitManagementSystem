package com.kwit.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.RecordMemberRecharge;
import com.kwit.service.DataMemberInformationService;
import com.kwit.service.RecordMemberRechargeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class RecordMemberRechargeTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected RecordMemberRechargeService recordMemberRechargeService;
	
	@Resource
	protected DataMemberInformationService dataMemberInformationService;
	
	RecordMemberRecharge recordMemberRecharge=new RecordMemberRecharge();
	
	List<RecordMemberRecharge> list=null;

	@Test
	public void getRecordMemberTest(){
		list=recordMemberRechargeService.getRecordMemberRecharge("123456789111111111");
		for(RecordMemberRecharge a:list){
			System.out.println(a);
		}
	}
	
	@Test
	public void addRecordMemberTest(){
		//List<DataMemberInformation> dataMemberInformationList=dataMemberInformationService.getMemberInformation("123456789111111111");
		//for(DataMemberInformation a:dataMemberInformationList){
		//	System.out.println(a);
		//}
		//System.out.println(dataMemberInformationList);
		Timestamp timesTamp = new Timestamp(new Date().getTime());

        
        
		recordMemberRecharge.setSocialCreditCode("123456");
		recordMemberRecharge.setStoreName("ceshi");
		recordMemberRecharge.setMemberName("会员名称1");
		recordMemberRecharge.setMemberPhone("1111111");
		recordMemberRecharge.setMemberIdNumber("身份证号");
		recordMemberRecharge.setPaymentMethod("1");
		recordMemberRecharge.setRechargeDate(timesTamp);
		recordMemberRecharge.setRechargeAmount((double) 20);
		recordMemberRecharge.setCreateDate(timesTamp);
		Map<String, String> list=recordMemberRechargeService.addRecordMemberRecharge(recordMemberRecharge,9);
		System.out.println(list);
	}
	
	@Test
	public void updateRecordMemberTest(){
		recordMemberRecharge.setId(1);
		recordMemberRecharge.setSocialCreditCode("123456");
		recordMemberRecharge.setStoreName("ceshi");
		recordMemberRecharge.setMemberName("会员名称1");
		recordMemberRecharge.setMemberPhone("1111111");
		recordMemberRecharge.setMemberIdNumber("身份证号");
		Map<String,String> list=recordMemberRechargeService.updateRecordMemberRecharge(recordMemberRecharge);
		System.out.println(list);
	}
	
	@Test
	public void deleteRecordMemberTest(){
		recordMemberRecharge.setId(5);
		Map<String, String> list=recordMemberRechargeService.deleteRecordMemberRecharge(recordMemberRecharge);
		System.out.println(list);
	}
	
}

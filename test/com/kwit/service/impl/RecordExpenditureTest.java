package com.kwit.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.model.RecordExpenditure;
import com.kwit.service.RecordExpenditureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class RecordExpenditureTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected RecordExpenditureService recordExpenditureService;
	
	RecordExpenditure t=new RecordExpenditure();
	
	List<RecordExpenditure> list=null;
	
	@Test
	public void getRecordExpenditureTest(){
		list=recordExpenditureService.getRecordExpenditure("123456");
		System.out.print(list);
	}
	
	@Test
	public void deleteRecordExpenditureTest(){
		t.setId(1);
		Map<String,String> map=recordExpenditureService.deleteRecordExpenditure(t);
		System.out.print(map);
	}
	
	@Test
	public void updateRecordExpenditureTest(){
		t.setId(1);
		Map<String,String> map=recordExpenditureService.updateRecordExpenditure(t);
		System.out.print(map);
	}
	
	@Test
	public void addRecordExpenditureTest(){
		t.setId(1);
		Map<String,String> map=recordExpenditureService.addRecordExpenditure(t);
		System.out.print(map);
	}

}
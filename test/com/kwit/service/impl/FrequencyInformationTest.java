package com.kwit.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.model.FrequencyInformation;
import com.kwit.service.FrequencyInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class FrequencyInformationTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected FrequencyInformationService frequencyInformationService;
	
	@Test
	public void addFrequency(){
		FrequencyInformation f=new FrequencyInformation();
		f.setId(1);
		f.setSocialCreditCode("1");
		f.setStoreName("1");
		f.setFrequencyName("1");
		f.setFrequencyTimes("1");
		f.setRemark("1");
		Map<String, String> map=frequencyInformationService.addFrequencyInformation(f);
		System.out.println(map);
	}
	
	@Test
	public void getFrequency(){
		List<FrequencyInformation> map=frequencyInformationService.getFrequencyInformation("2");
		System.out.println(map);
	}
}

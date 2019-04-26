package com.kwit.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.model.DataClassifiedInformation;
import com.kwit.service.DataClassifiedInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataClassifiedInformationTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataClassifiedInformationService dataClassifiedInformationService;
	
	DataClassifiedInformation t=new DataClassifiedInformation();
	
	/*
	 * 获取测试
	 */
	@Test
	public void getAllTest(){
		List<DataClassifiedInformation> list=dataClassifiedInformationService.getProductClassified("123456");
		System.out.println(list);
	}
	
	/*
	 * 新增测试
	 */
	@Test
	public void addProductClassifiedTest(){
		t.setSocialCreditCode("信用代码04");
		t.setStoreName("门店04");
		t.setCommodityClassification("商品分类04");
		Map<String, String> list=dataClassifiedInformationService.addProductClassified(t);
		System.out.println(list);
	}
	
	/*
	 * 更新测试
	 */
	@Test
	public void updateProductClassifiedTest(){
		List<DataClassifiedInformation> list=dataClassifiedInformationService.getProductClassified("123456");
		for(DataClassifiedInformation a:list){
			System.out.println(a);
		}
		
	}
	
	/*
	 * 删除测试
	 */
	@Test
	public void deleteProductClassifiedTest(){
		t.setId(12);
		Map<String, String> list=dataClassifiedInformationService.deleteProductClassified(t);
		System.out.println(list);
	}
	

}

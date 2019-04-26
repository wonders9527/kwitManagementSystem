package com.kwit.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.model.DataEmployeePosition;
import com.kwit.service.DataEmployeePositionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataEmployeePositionTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataEmployeePositionService dataEmployeePositionService;
	
	DataEmployeePosition t=new DataEmployeePosition();
	
	/*
	 * 获取测试
	 */
	@Test
	public void getAllTest(){
		List<DataEmployeePosition> list=dataEmployeePositionService.getEmployeePosition("123456789111111111");
		for(DataEmployeePosition a:list){
			System.out.println(a);
		}
		
	}
	
	/*
	 * 新增测试
	 */
	@Test
	public void addProductClassifiedTest(){
		
	}
	
	/*
	 * 更新测试
	 */
	@Test
	public void updateProductClassifiedTest(){
		
	}
	
	/*
	 * 删除测试
	 */
	@Test
	public void deleteProductClassifiedTest(){
		
	}

}

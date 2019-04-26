package com.kwit.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.service.BaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class BaseServiceTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected BaseService<?> baseService;
	
	@Test
	public void sessionTest(){
		
	}
}

package com.kwit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.UserTable;
import com.kwit.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class UserTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected UserService userService;

	
	@Test
	public void getAll(){
		List<UserTable> list=userService.getAll();
		System.out.println(list);
	}
	
	@Test
	public void loginTest(){
		List<UserTable> list=userService.login("admin","123456");
		System.out.println(list);
	}
}

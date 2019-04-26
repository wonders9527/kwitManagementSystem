package com.kwit.service.impl;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwit.model.DataStockProduct;
import com.kwit.service.DataStockProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataStockProductTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataStockProductService dataStockProductService;
	
	DataStockProduct t=new DataStockProduct();

}

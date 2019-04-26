package com.kwit.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwit.model.DataProductInformation;
import com.kwit.service.DataProductInformationService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class DataProductInformationTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected DataProductInformationService dataProductInformationService;
	
	DataProductInformation t=new DataProductInformation();
	
	@Test
	public void uploadPictureTest(){
	    File upload = new File("D:/timg.jpg");
	    String uploadFileName="timg.jpg";
	    String uploadContentType="jpg";
	    Map<String, String> map=dataProductInformationService.uploadPicturePro(upload, uploadFileName, uploadContentType);
	    System.out.println(map);
	}
	
	@Test
	public void getProductInforTest(){
		List<DataProductInformation> list=dataProductInformationService.getProductInfor("ceshi");
		System.out.println(list);
	}
	
	@Test
	public void getProductInforLimtTest(){
		List<DataProductInformation> list=dataProductInformationService.getProductInforLimt("123456789111111111",10,1);
		for(DataProductInformation a:list){
			System.out.println(a);
		}
	}
	
	@Test
	public void deleteProductInforTest(){
		t.setId(5);
		Map<String, String> list=dataProductInformationService.deleteProductInfor(t);
		System.out.println(list);
	}
	
	@Test
	public void updateProductInforTest(){
		t.setId(5);
		t.setSocialCreditCode("yyyyy");
		t.setCommodityName("yyyy");
		t.setCommodityPrice("yyyyyy");
		Map<String, String> list=dataProductInformationService.updateProductInfor(t);
		System.out.println(list);
	}
	
	@Test
	public void saveProductInfor(){

		t.setSocialCreditCode("ceshi");
		t.setCommodityName("ceshi");
		t.setCommodityPrice("ceshi");
		Map<String, String> list=dataProductInformationService.saveProductInfor(t);
		System.out.println(list);
	}
}

























package com.kwit.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Icon;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.kwit.action.FrequencyInformationAction;
import com.kwit.model.DataProductInformation;
import com.kwit.model.DataRechargeInformation;
import com.kwit.model.UserTable;
import com.kwit.service.BaseService;

import net.sf.json.JSONObject;


@SuppressWarnings("all")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T>{

	private Class clazz;
	
	private Transaction strans;

	private static SessionFactory sessionFactory;
	
	@Autowired
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	
	@Override
	public Map<String, String> save(T t) {
		Map<String, String> map=new HashMap<String, String>();
		try {
			getSession().save(t);
			map.put("mark", "1");
			map.put("result", "保存成功");
		} catch (Exception e) {
			map.put("mark", "0");
			map.put("result", "保存失败");
		}finally{
			getSession().getTransaction().commit();
		}
		return map;	
	}

	@Override
	public Map<String, String> delete(T t) {
		Map<String, String> map=new HashMap<String, String>();
		if(t!=null){
			try{
				getSession().delete(t);
				map.put("mark", "1");
				map.put("result", "删除成功");
			}catch(Exception e){
				map.put("mark", "0");
				map.put("result", "删除失败");
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else{
			map.put("mark", "2");
			map.put("result", "数据不存在");
		}
		return map;
	}

	@Override
	public Map<String, String> update(T t) {
		Map<String, String> map=new HashMap<String, String>();
		if(t!=null){
			try{
				getSession().update(t);
				map.put("mark", "1");
				map.put("result", "更新成功");
			}catch(Exception e){
				map.put("mark", "0");
				map.put("result", "更新失败");
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
				
		}else{
			map.put("mark", "2");
			map.put("result", "数据不存在");
		}
		return map;
	}

	@Override
	public Map<String, String> uploadPicture(File upload, String uploadFileName, String uploadContentType){
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(timesTamp)+"_"+uploadFileName;
		if (upload != null) {
            try {
                String path = BaseServiceImpl.class
                		.getResource("/")
                		.getPath()
                		.replace('/', '\\')
                		.replace("classes\\", "")
                		.replace("WEB-INF\\", "").substring(1)+"images\\";
                String realPath = URLDecoder.decode(path, "utf-8");
            	File diskFile = new File(realPath+File.separator+ fileName);
                FileUtils.copyFile(upload, diskFile);  // 文件上传,使用FileUtils工具类
                map.put("mark", "1");
                map.put("result", "保存成功");
                map.put("fileName", fileName);
            } catch (IOException e) {
            	map.put("mark", "1");
                map.put("result", "保存失败");
                e.printStackTrace();
            }
        }
		return map;
	}
	
	@Override
	public int stransJudge(){
		if(strans!= null && strans.isActive()){
			return 1;		
		}else{
			return 0;
		}
	}

	
}

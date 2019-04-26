package com.kwit.action;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.UserTable;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



@SuppressWarnings("all")
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ServletContextAware,ServletRequestAware,ServletResponseAware,ModelDriven<T>{

	protected T model;
	
	protected List<T> jsonList = new LinkedList<T>();
	
	protected Map<String,Object> requestMap;
	protected Map<String,Object> sessionMap;
	protected Map<String,Object> applicationMap; 
	protected Map<String,String[]> parametersMap;
	
	protected HttpServletRequest request;
	protected HttpServletResponse response; 
	protected ServletContext application;
	

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;		
	}

	public void setServletContext(ServletContext application) {
		this.application=application;		
	}

	public void setParameters(Map<String, String[]> parametersMap) {
		this.parametersMap=parametersMap;		
	}

	public void setApplication(Map<String, Object> applicationMap) {
		this.applicationMap=applicationMap;		
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;		
	}

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap=requestMap;		
	}
	
	public List<T> getJsonList() {
		
		return jsonList;
	}
	
	public T getModel() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}

	
}

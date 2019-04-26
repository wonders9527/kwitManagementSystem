package com.kwit.listener;
 
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitDataListener implements ServletContextListener {
	
//	private DataentrytableService dataentrytableService;
	
	private ApplicationContext context = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		setContext(WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()));		
//		setDataentrytableService((DataentrytableService) context.getBean("dataentrytableService"));
		
		
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
}

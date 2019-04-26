package com.kwit.filter;
 
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器登录功能
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		//判断当前session是否有用户信息
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		//获得用户请求的URI
		String path = req.getRequestURI();
		String userName = (String)session.getAttribute("userName");
		if(path.indexOf("/login.html") > -1){				
			chain.doFilter(req, res);
			return;
		}
		
		// 登陆页面无需过滤
		if(userName == null || "".equals(userName)){			
			res.sendRedirect(req.getContextPath() + "/login.html");
		}else{
			chain.doFilter(req, res);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

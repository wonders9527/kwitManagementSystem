package com.kwit.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.UserTable;
import com.kwit.service.UserService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<UserTable>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected UserService userService;
	
	private JSONObject result;
	
	public String getUser0(){
		jsonList = userService.getAll();
		return "jsonList";
	}
	
	public String login(){
		Map<String, String> map=new HashMap<String, String>();
		if(sessionMap.get("userName")!=null&&sessionMap.get("userName")==model.getUserName()){
			sessionMap.put("mark", "1");
			sessionMap.put("result", "用户存在");
			JSONObject json = JSONObject.fromObject(sessionMap);	
			setResult(json);
			return SUCCESS; 
		}else if(model==null){
			sessionMap.put("error", "登陆失败");
			return "login";
		}else{
			List<UserTable> list = userService.login(model.getUserName(),model.getPassword());
			if(list.size()>0){
				sessionMap.put("userName", list.get(0).getUserName());
				sessionMap.put("userRole", list.get(0).getUserRole());
				sessionMap.put("socialCreditCode", list.get(0).getSocialCreditCode());
				sessionMap.put("storeName", list.get(0).getStoreName());
				map.put("userRole", list.get(0).getUserRole());
				map.put("userName", list.get(0).getUserName());
				map.put("socialCreditCode", list.get(0).getSocialCreditCode());
				map.put("storeName", list.get(0).getStoreName());
				map.put("mark", "1");
				map.put("result", "用户存在");
			}else{
				map.put("mark", "0");
				map.put("result", "没有该用户或密码错误");
			}
			JSONObject json = JSONObject.fromObject(map);	
			setResult(json);
			return SUCCESS;  
		}
	}

	public JSONObject getResult() {
		return result;
	}
	
	public void setResult(JSONObject result) {
		this.result = result;
	}

}

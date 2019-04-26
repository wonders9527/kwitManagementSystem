package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.DataEmployeePosition;
import com.kwit.service.DataEmployeePositionService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class DataEmployeePositionAction extends BaseAction<DataEmployeePosition> {

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected DataEmployeePositionService dataEmployeePositionService;

	private JSONObject result;
	
	public String getEmployeePosition(){
		jsonList = dataEmployeePositionService.getEmployeePosition(model.getSocialCreditCode());
		return "jsonList";
	}
	
	public String addEmployeePosition(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataEmployeePositionService.addEmployeePosition(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String updateEmployeePosition(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataEmployeePositionService.updateEmployeePosition(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String deleteEmployeePosition(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataEmployeePositionService.deleteEmployeePosition(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

}

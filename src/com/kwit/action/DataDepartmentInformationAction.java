package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.DataDepartmentInformation;
import com.kwit.service.DataDepartmentInformationService;

import net.sf.json.JSONObject;


@Controller
@Scope("prototype")
public class DataDepartmentInformationAction extends BaseAction<DataDepartmentInformation>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected DataDepartmentInformationService dataDepartmentInformationService;

	private JSONObject result;
	
	public String getDepartment(){
		jsonList = dataDepartmentInformationService.getDepartment(model.getSocialCreditCode());
		return "jsonList";
	}
	
	public String addDepartment(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataDepartmentInformationService.addDepartment(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String updateDepartment(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataDepartmentInformationService.updateDepartment(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String deleteDepartment(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataDepartmentInformationService.deleteDepartment(model);
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

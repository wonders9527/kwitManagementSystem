package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kwit.model.DataMemberGrade;
import com.kwit.service.DataMemberGradeService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class DataMemberGradeAction extends BaseAction<DataMemberGrade>{
	
	private static final long serialVersionUID = 1L;

	@Resource
	protected DataMemberGradeService dataMemberGradeService;
	
	private JSONObject result;
	
	public String getMemberGrade(){
		jsonList = dataMemberGradeService.getMemberGrade(model.getSocialCreditCode());
		return "jsonList";
	}
	
	public String addMemberGrade(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataMemberGradeService.addMemberGrade(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	
	public String updateMemberGrade(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataMemberGradeService.updateMemberGrade(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	

	public String deleteMemberGrade(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataMemberGradeService.deleteMemberGrade(model);
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

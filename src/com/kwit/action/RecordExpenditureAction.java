package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.RecordExpenditure;
import com.kwit.service.RecordExpenditureService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class RecordExpenditureAction extends BaseAction<RecordExpenditure>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected RecordExpenditureService recordExpenditureService;
	
	private JSONObject json;
	
	public String getRecordExpenditure(){
		jsonList = recordExpenditureService.getRecordExpenditure(sessionMap.get("socialCreditCode").toString());
		return "jsonList";
	}

	public String addRecordExpenditure(){
		Map<String, String> map=new HashMap<String, String>();
		model.setSocialCreditCode(sessionMap.get("socialCreditCode").toString());
		model.setStoreName(sessionMap.get("storeName").toString());
		map = recordExpenditureService.addRecordExpenditure(model);
		setJson(JSONObject.fromObject(map));
		return SUCCESS;
	}

	public String updateRecordExpenditure(RecordExpenditure model){
		Map<String, String> map=new HashMap<String, String>();
		map = recordExpenditureService.updateRecordExpenditure(model);
		setJson(JSONObject.fromObject(map));
		return SUCCESS;
	}
	
	public String deleteRecordExpenditure(RecordExpenditure model){
		Map<String, String> map=new HashMap<String, String>();
		map = recordExpenditureService.deleteRecordExpenditure(model);
		setJson(JSONObject.fromObject(map));
		return SUCCESS;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

}

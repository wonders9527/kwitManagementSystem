package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kwit.model.RecordPurchase;
import com.kwit.service.RecordPurchaseService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class RecordPurchaseAction extends BaseAction<RecordPurchase> {

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected RecordPurchaseService recordPurchaseService;
	
	private JSONObject result;
	
	public String getPurchase(){
		jsonList = recordPurchaseService.getPurchase(sessionMap.get("socialCreditCode").toString());
		return "jsonList";
	}

	public String addPurchase(){
		Map<String, String> map=new HashMap<String, String>();
		map = recordPurchaseService.addPurchase(model);
		setResult(JSONObject.fromObject(map));
		return SUCCESS;
	}


	public String updatePurchase(RecordPurchase model){
		Map<String, String> map=new HashMap<String, String>();
		map = recordPurchaseService.updatePurchase(model);
		setResult(JSONObject.fromObject(map));
		return SUCCESS;
	}
	

	public String deletePurchase(RecordPurchase model){
		Map<String, String> map=new HashMap<String, String>();
		map = recordPurchaseService.deletePurchase(model);
		setResult(JSONObject.fromObject(map));
		return SUCCESS;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

}

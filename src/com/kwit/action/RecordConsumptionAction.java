package com.kwit.action;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.RecordConsumption;
import com.kwit.service.RecordConsumptionService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class RecordConsumptionAction extends BaseAction<RecordConsumption>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected RecordConsumptionService recordConsumptionService;
	
	private JSONObject result;
	
	public String saveRecordConsumption(){		
		Map<String, String> map=new HashMap<String, String>();
		map = recordConsumptionService.saveRecordConsumption(model);
		setResult(JSONObject.fromObject(map));
		return SUCCESS;
	}
	
	public String getRecordConsumption(){
		jsonList = recordConsumptionService.getRecordConsumption(model.getSocialCreditCode());
		return "jsonList";
	}
	
	public String updateRecordConsumption(){
		Map<String, String> map=new HashMap<String, String>();
		map = recordConsumptionService.updateRecordConsumption(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
		
	}
	
	public String deleteRecordConsumption(){
		Map<String, String> map=new HashMap<String, String>();
		map = recordConsumptionService.deleteRecordConsumption(model);
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

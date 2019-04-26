package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.DataStockProduct;
import com.kwit.service.DataStockProductService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class DataStockProductAction extends BaseAction<DataStockProduct>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected DataStockProductService dataStockProductService;
	
	private JSONObject result;
	
	public String saveDataStockProduct(){		
		Map<String, String> map=new HashMap<String, String>();
		model.setSocialCreditCode(sessionMap.get("socialCreditCode").toString());
		model.setStoreName(sessionMap.get("storeName").toString());
		map = dataStockProductService.saveDataStockProduct(model);
		setResult(JSONObject.fromObject(map));
		return SUCCESS;
	}
	
	public String getDataStockProduct(){
		jsonList = dataStockProductService.getDataStockProduct(sessionMap.get("socialCreditCode").toString());
		System.out.println(jsonList);
		return "jsonList";
	}
	
	public String updateDataStockProduct(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataStockProductService.updateDataStockProduct(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
		
	}
	
	public String deleteDataStockProduct(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataStockProductService.deleteDataStockProduct(model);
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

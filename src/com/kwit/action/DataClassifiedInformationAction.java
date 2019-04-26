package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.DataClassifiedInformation;
import com.kwit.service.DataClassifiedInformationService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class DataClassifiedInformationAction extends BaseAction<DataClassifiedInformation>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected DataClassifiedInformationService dataClassifiedInformationService;
	
	private JSONObject result;
	
	/*
	 * 获取商品分类信息
	 */
	public String getProductClassified(){
		jsonList = dataClassifiedInformationService.getProductClassified(model.getSocialCreditCode());
		return "jsonList";
	}
	
	/*
	 * 新增商品分类信息
	 */
	public String addProductClassified(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataClassifiedInformationService.addProductClassified(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	/*
	 * 更新商品分类信息
	 */
	public String updateProductClassified(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataClassifiedInformationService.updateProductClassified(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	/*
	 * 删除商品分类信息
	 */
	public String deleteProductClassified(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataClassifiedInformationService.deleteProductClassified(model);
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

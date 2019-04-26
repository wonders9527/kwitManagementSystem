package com.kwit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kwit.model.DataSupplierInformation;
import com.kwit.service.DataSupplierInformationService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class DataSupplierInformationAction  extends BaseAction<DataSupplierInformation>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected DataSupplierInformationService dataSupplierInformationService;
	
	private JSONObject result;
	
	/*
	 * 获取供应商信息
	 */
	public String getSupplierInfor(){
		jsonList = dataSupplierInformationService.getSupplierInfor(model.getSocialCreditCode());
		return "jsonList";
	}
	
	/*
	 * 新增供应商信息
	 */
	public String addSupplierInfor(){
		System.out.println(model);
		Map<String, String> map=new HashMap<String, String>();
		map = dataSupplierInformationService.addSupplierInfor(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	/*
	 * 更新供应商信息
	 */
	public String updateSupplierInfor(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataSupplierInformationService.updateSupplierInfor(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	/*
	 * 删除供应商信息
	 */
	public String deleteSupplierInfor(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataSupplierInformationService.deleteSupplierInfor(model);
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

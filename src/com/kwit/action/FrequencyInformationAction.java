package com.kwit.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.FrequencyInformation;
import com.kwit.service.FrequencyInformationService;

import net.sf.json.JSONObject;


@Controller
@Scope("prototype")
public class FrequencyInformationAction extends BaseAction<FrequencyInformation>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected FrequencyInformationService frequencyInformationService;
	
	private JSONObject result;
	
	private File upload;   // 上传的文件
	
	private String uploadFileName;  //上传的文件名陈
	
	private String uploadContentType;  // 接收文件上传的MIME类型
	
	private String realPath;
	
	public String uploadPicture(){
		Map<String, String> map=new HashMap<String, String>();
		map=frequencyInformationService.uploadPicture(upload,uploadFileName,uploadContentType);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String addFrequencyInformation(){
		Map<String, String> map=new HashMap<String, String>();
		model.setSocialCreditCode(sessionMap.get("socialCreditCode").toString());
		model.setStoreName(sessionMap.get("storeName").toString());
		map = frequencyInformationService.addFrequencyInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String getFrequencyInformation(){
		jsonList = frequencyInformationService.getFrequencyInformation(sessionMap.get("socialCreditCode").toString());
		return "jsonList";
	}

	public String deleteFrequencyInformation(){
		Map<String, String> map=new HashMap<String, String>();
		map = frequencyInformationService.deleteFrequencyInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}

	public String updateFrequencyInformation(){
		Map<String, String> map=new HashMap<String, String>();
		map = frequencyInformationService.updateFrequencyInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

}

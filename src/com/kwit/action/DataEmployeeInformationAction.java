package com.kwit.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kwit.model.DataEmployeeInformation;
import com.kwit.service.DataEmployeeInformationService;

import net.sf.json.JSONObject;
 
@Controller
@Scope("prototype")
public class DataEmployeeInformationAction extends BaseAction<DataEmployeeInformation>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected DataEmployeeInformationService dataEmployeeInformationService;
	
	private File upload;        // 上传的文件
	
	private String uploadFileName;     //上传的文件名陈
	
	private String uploadContentType;  // 接收文件上传的MIME类型
	
	private String realPath;
	
	private JSONObject result;
	
	public String uploadPicture(){
		Map<String, String> map=new HashMap<String, String>();
		map=dataEmployeeInformationService.uploadEmployeePicture(upload,uploadFileName,uploadContentType);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String getEmployeeInformation(){
		jsonList = dataEmployeeInformationService.getEmployeeInformation(model.getSocialCreditCode());
		return "jsonList";
	}
	
	public String addEmployeeInformation(){
		
		Map<String, String> map=new HashMap<String, String>();
		map = dataEmployeeInformationService.addEmployeeInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String updateEmployeeInformation(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataEmployeeInformationService.updateEmployeeInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String deleteEmployeeInformation(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataEmployeeInformationService.deleteEmployeeInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String getEmployeeInformationById(){
		jsonList = dataEmployeeInformationService.getEmployeeInformationById(model.getId());
		return "jsonList";
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

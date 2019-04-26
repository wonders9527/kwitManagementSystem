package com.kwit.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.DataMemberInformation;
import com.kwit.service.DataMemberInformationService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class DataMemberInformationAction extends BaseAction<DataMemberInformation> {

	private static final long serialVersionUID = 1L;

	@Resource
	protected DataMemberInformationService dataMemberInformationService;
	
	// 上传的文件
	private File upload; 
	
	//上传的文件名陈
	private String uploadFileName;  
	
	// 接收文件上传的MIME类型
	private String uploadContentType; 
	
	private String realPath;
	
	private JSONObject result;
	
	public String uploadPicture(){
		Map<String, String> map=new HashMap<String, String>();
		map=dataMemberInformationService.uploadMemberPicture(upload,uploadFileName,uploadContentType);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	public String getMemberInformation(){
		jsonList = dataMemberInformationService.getMemberInformation(model.getSocialCreditCode());
		return "jsonList";
	}
	
	public String addMemberInformation(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataMemberInformationService.addMemberInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	
	public String updateMemberInformation(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataMemberInformationService.updateMemberInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	

	public String deleteMemberInformation(){
		Map<String, String> map=new HashMap<String, String>();
		map = dataMemberInformationService.deleteMemberInformation(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	
	public String getMemberInformationByPhone(){
		jsonList = dataMemberInformationService.getMemberInformationByPhone(model.getSocialCreditCode(),model.getMemberPhone());
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

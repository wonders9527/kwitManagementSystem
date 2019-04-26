 package com.kwit.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.DataProductInformation;
import com.kwit.service.DataProductInformationService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class DataProductInformationAction extends BaseAction<DataProductInformation>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected DataProductInformationService dataProductInformationService;
	
	private File upload;        // 上传的文件
	
	private String uploadFileName;     //上传的文件名陈
	
	private String uploadContentType;  // 接收文件上传的MIME类型
	
	private String realPath;
	
	private int pageSize; //每页要显示的条数
	
	private int pageNumber;  //页码
	
	private JSONObject result;
	
	/*
	 * 保存商品图片
	 */
	public String uploadPicture(){
		Map<String, String> map=new HashMap<String, String>();
		map=dataProductInformationService.uploadPicturePro(upload,uploadFileName,uploadContentType);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	/*
	 * 保存新增商品信息
	 */
	public String saveProductInfor(){
	  Map<String, String> map=new HashMap<String, String>();
	  map=dataProductInformationService.saveProductInfor(model);
	  setResult(JSONObject.fromObject(map));
      return SUCCESS;		
	}
	
	/*
	 * 获取商品全部信息
	 */
	public String getProductInfor(){
		jsonList = dataProductInformationService.getProductInfor(model.getSocialCreditCode());
		return "jsonList";
	}
	
	public String getProductInforById(){
		jsonList = dataProductInformationService.getProductInforById(model.getId());
		return "jsonList";
	}
	
	
	public String getProductInforLimt(){
		jsonList = dataProductInformationService.getProductInforLimt(model.getSocialCreditCode(),pageSize,pageNumber);
		return "jsonList";
	}
	
	/*
	 * 删除商品信息
	 */
	public String deleteProductInfor(){	
	  Map<String, String> map=new HashMap<String, String>();
	  map=dataProductInformationService.deleteProductInfor(model);
	  setResult(JSONObject.fromObject(map));
      return SUCCESS;		
	}
	
	/*
	 * 更新商品信息
	 */
	public String updateProductInfor(){
	  Map<String, String> map=new HashMap<String, String>();
	  map=dataProductInformationService.updateProductInfor(model);
	  setResult(JSONObject.fromObject(map));
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
}

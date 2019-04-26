package com.kwit.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataProductInformation;
import com.kwit.service.DataProductInformationService;

@Service("dataProductInformationService")
public class DataProductInformationServiceImpl extends BaseServiceImpl<DataProductInformation> implements DataProductInformationService{
	
	List<DataProductInformation> list = null;
	
	@Override
	public Map<String, String> saveProductInfor(DataProductInformation t) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		t.setCreateDate(timesTamp);
		if(stransJudge()==0){
			getSession().beginTransaction();
			map=save(t);
		}else if(stransJudge()==1){
			map=save(t);
		}
		return map;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataProductInformation> getProductInfor(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_product_information where social_credit_code="+"'"+socialCreditCode+"'");
		int strans=stransJudge();
		if(strans==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataProductInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction() .commit();
			}
		}else if(strans==1){
			list=getSession().createSQLQuery(sql.toString()).addEntity(DataProductInformation.class).list();
		}
		return list;
	}

	@Override
	public Map<String, String> deleteProductInfor(DataProductInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		int strans=stransJudge();
		if(strans==1){
			DataProductInformation dataProductInformation=(DataProductInformation) getSession().get(DataProductInformation.class, model.getId());
			map=delete(dataProductInformation);
		}else if(strans==0){
			getSession().beginTransaction();
			DataProductInformation dataProductInformation=(DataProductInformation) getSession().get(DataProductInformation.class, model.getId());
			map=delete(dataProductInformation);
		}
		return map;
	}

	@Override
	public Map<String, String> updateProductInfor(DataProductInformation t) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		t.setCreateDate(timesTamp);
		getSession().beginTransaction();
		map=update(t);
		return map;
	}

	@Override
	public Map<String, String> uploadPicturePro(File upload, String uploadFileName, String uploadContentType) {
		Map<String, String> map=new HashMap<String, String>();
		map=uploadPicture(upload,uploadFileName,uploadContentType);
		return map;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DataProductInformation> getProductInforById(Integer id) {
		StringBuffer sql = new StringBuffer("select * from data_product_information where id=");
		sql.append(id);
		int strans=stransJudge();
		if(strans==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataProductInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(strans==1){
			list=getSession().createSQLQuery(sql.toString()).addEntity(DataProductInformation.class).list();
		}
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataProductInformation> getProductInforLimt(String socialCreditCode, int pageSize, int pageNumber) {
		StringBuffer sql = new StringBuffer("select * from data_product_information WHERE social_credit_code=");
		sql.append("'"+socialCreditCode+"'");
		sql.append("limit");
		sql.append(" ");
		sql.append((pageNumber-1)*pageSize);
		sql.append(",");
		sql.append(pageSize);
		int strans=stransJudge();
		if(strans==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataProductInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(strans==1){
			list=getSession().createSQLQuery(sql.toString()).addEntity(DataProductInformation.class).list();
		}
		
		return list;
	}
	
}

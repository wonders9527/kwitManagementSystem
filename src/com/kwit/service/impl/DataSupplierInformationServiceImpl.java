package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kwit.model.DataSupplierInformation;
import com.kwit.service.DataSupplierInformationService;

@Service("dataSupplierInformationService")
public class DataSupplierInformationServiceImpl extends BaseServiceImpl<DataSupplierInformation> implements DataSupplierInformationService {
	
	List<DataSupplierInformation> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataSupplierInformation> getSupplierInfor(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_supplier_information where social_credit_code="+"'"+socialCreditCode+"'");
		int strans=stransJudge();
		if(strans==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataSupplierInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(strans==1){
			list=getSession().createSQLQuery(sql.toString()).addEntity(DataSupplierInformation.class).list();
		}
		
		return list;
	}

	@Override
	public Map<String, String> addSupplierInfor(DataSupplierInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		if(stransJudge()==0){
			getSession().beginTransaction();
			map=save(model);
		}else if(stransJudge()==1){
			map=save(model);
		}
		return map;	
	}

	@Override
	public Map<String, String> updateSupplierInfor(DataSupplierInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		if(stransJudge()==0){
			getSession().beginTransaction();
			map=update(model);
		}else if(stransJudge()==1){
			map=update(model);
		}
		return map;	
	}

	@Override
	public Map<String, String> deleteSupplierInfor(DataSupplierInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		int strans=stransJudge();
		//getSession().beginTransaction();
		if(strans==1){
			DataSupplierInformation dataSupplierInformation=(DataSupplierInformation) getSession().get(DataSupplierInformation.class, model.getId());
			map=delete(dataSupplierInformation);
		}else if(strans==0){
			getSession().beginTransaction();
			DataSupplierInformation dataSupplierInformation=(DataSupplierInformation) getSession().get(DataSupplierInformation.class, model.getId());
			map=delete(dataSupplierInformation);
		}
		return map;
	}

}

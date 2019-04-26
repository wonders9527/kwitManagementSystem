package com.kwit.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.kwit.model.DataRechargeInformation;
import com.kwit.service.DataRechargeInformationService;

@Service("dataRechargeInformationService")
public class DataRechargeInformationServiceImpl extends BaseServiceImpl<DataRechargeInformation> implements DataRechargeInformationService{

	List<DataRechargeInformation> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataRechargeInformation> getRecharge(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_recharge_information where social_credit_code="+socialCreditCode);

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataRechargeInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataRechargeInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> saveRecharge(DataRechargeInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		getSession().beginTransaction();
		map=save(model);
		return map;	
	}

	@Override
	public Map<String, String> updateRecharge(DataRechargeInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		getSession().beginTransaction();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		map=update(model);
		return map;
	}

	@Override
	public Map<String, String> deleteRecharge(DataRechargeInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataRechargeInformation dataRechargeInformation=(DataRechargeInformation) getSession().get(DataRechargeInformation.class, model.getId());
			map=delete(dataRechargeInformation);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataRechargeInformation dataRechargeInformation=(DataRechargeInformation) getSession().get(DataRechargeInformation.class, model.getId());
			map=delete(dataRechargeInformation);
		}
		return map;
	}

	@Override
	public Map<String, String> uploadPictureRecharge(File upload, String uploadFileName, String uploadContentType) {
		Map<String, String> map=new HashMap<String, String>();
		map=uploadPicture(upload,uploadFileName,uploadContentType);
		return map;
	}

}

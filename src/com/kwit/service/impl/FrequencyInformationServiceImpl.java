package com.kwit.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.FrequencyInformation;
import com.kwit.service.FrequencyInformationService;

@Service("frequencyInformationService")
public class FrequencyInformationServiceImpl extends BaseServiceImpl<FrequencyInformation> implements FrequencyInformationService{
	
	List<FrequencyInformation> list = null;
	
	@Override
	public Map<String, String> addFrequencyInformation(FrequencyInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		map=save(model);
		return map;	
	}
	
	@Override
	public Map<String, String> uploadPicture(File upload, String uploadFileName, String uploadContentType) {
		Map<String, String> map=new HashMap<String, String>();
		map= uploadPicture(upload,uploadFileName,uploadContentType);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrequencyInformation> getFrequencyInformation(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from frequency_information where social_credit_code="+socialCreditCode);

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(FrequencyInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(FrequencyInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> deleteFrequencyInformation(FrequencyInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			FrequencyInformation frequencyInformation=(FrequencyInformation) getSession().get(FrequencyInformation.class, model.getId());
			map=delete(frequencyInformation);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			FrequencyInformation frequencyInformation=(FrequencyInformation) getSession().get(FrequencyInformation.class, model.getId());
			map=delete(frequencyInformation);
		}
		return map;
	}

	@Override
	public Map<String, String> updateFrequencyInformation(FrequencyInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		getSession().beginTransaction();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		map=update(model);
		return map;
	}

}

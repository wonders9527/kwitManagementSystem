package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.RecordConsumption;
import com.kwit.service.RecordConsumptionService;

@Service("recordConsumptionService")
public class RecordConsumptionServiceImpl extends BaseServiceImpl<RecordConsumption> implements RecordConsumptionService{

	List<RecordConsumption> list = null;
	
	@Override
	public Map<String, String> saveRecordConsumption(RecordConsumption model) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<RecordConsumption> getRecordConsumption(String socialCreditCode) {
		
		StringBuffer sql = new StringBuffer("select * from record_consumption where social_credit_code="+socialCreditCode);
		
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(RecordConsumption.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(RecordConsumption.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> updateRecordConsumption(RecordConsumption model) {
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
	public Map<String, String> deleteRecordConsumption(RecordConsumption model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			RecordConsumption recordConsumption=(RecordConsumption) getSession().get(RecordConsumption.class, model.getId());
			map=delete(recordConsumption);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			RecordConsumption recordConsumption=(RecordConsumption) getSession().get(RecordConsumption.class, model.getId());
			map=delete(recordConsumption);
		}
		return map;
	}

}

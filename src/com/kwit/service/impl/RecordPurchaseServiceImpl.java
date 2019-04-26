package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kwit.model.RecordPurchase;
import com.kwit.service.RecordPurchaseService;

@Service("recordPurchaseService")
public class RecordPurchaseServiceImpl extends BaseServiceImpl<RecordPurchase> implements RecordPurchaseService {
	
	List<RecordPurchase> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecordPurchase> getPurchase(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from record_purchase where social_credit_code="+"'"+socialCreditCode+"'");
		int strans=stransJudge();
		if(strans==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(RecordPurchase.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(strans==1){
			list=getSession().createSQLQuery(sql.toString()).addEntity(RecordPurchase.class).list();
		}
		
		return list;
	}

	@Override
	public Map<String, String> addPurchase(RecordPurchase model) {
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
	public Map<String, String> updatePurchase(RecordPurchase model) {
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
	public Map<String, String> deletePurchase(RecordPurchase model) {
		Map<String, String> map=new HashMap<String, String>();
		int strans=stransJudge();
		//getSession().beginTransaction();
		if(strans==1){
			RecordPurchase recordPurchase=(RecordPurchase) getSession().get(RecordPurchase.class, model.getId());
			map=delete(recordPurchase);
		}else if(strans==0){
			getSession().beginTransaction();
			RecordPurchase recordPurchase=(RecordPurchase) getSession().get(RecordPurchase.class, model.getId());
			map=delete(recordPurchase);
		}
		return map;
	}

}

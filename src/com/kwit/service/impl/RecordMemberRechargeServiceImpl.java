package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kwit.model.RecordMemberRecharge;
import com.kwit.service.DataMemberInformationService;
import com.kwit.service.RecordMemberRechargeService;

@Service("recordMemberRechargeService")
public class RecordMemberRechargeServiceImpl extends BaseServiceImpl<RecordMemberRecharge> implements RecordMemberRechargeService{

	@Resource
	protected DataMemberInformationService dataMemberInformationService;
	
	List<RecordMemberRecharge> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecordMemberRecharge> getRecordMemberRecharge(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from record_member_recharge where social_credit_code=");
		sql.append("'"+socialCreditCode+"'");
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(RecordMemberRecharge.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(RecordMemberRecharge.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> addRecordMemberRecharge(RecordMemberRecharge model,int memberId) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		model.setRechargeDate(timesTamp);
		boolean resutl=dataMemberInformationService.editAccountBalance(memberId, model.getRechargeAmount());
		if(stransJudge()==0&&resutl==true){
			getSession().beginTransaction();
			map=save(model);
		}else if(stransJudge()==1&&resutl==true){
			map=save(model);
		}else{
			map.put("mark", "2");
			map.put("result", "失败");
		}
		return map;	
	}

	@Override
	public Map<String, String> updateRecordMemberRecharge(RecordMemberRecharge model) {
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
	public Map<String, String> deleteRecordMemberRecharge(RecordMemberRecharge model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			RecordMemberRecharge recordMemberRecharge=(RecordMemberRecharge) getSession().get(RecordMemberRecharge.class, model.getId());
			map=delete(recordMemberRecharge);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			RecordMemberRecharge recordMemberRecharge=(RecordMemberRecharge) getSession().get(RecordMemberRecharge.class, model.getId());
			map=delete(recordMemberRecharge);
		}
		return map;
	}


	
}

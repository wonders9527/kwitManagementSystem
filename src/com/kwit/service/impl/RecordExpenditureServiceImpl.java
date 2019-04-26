package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.RecordExpenditure;
import com.kwit.service.RecordExpenditureService;

@Service("recordExpenditureService")
public class RecordExpenditureServiceImpl extends BaseServiceImpl<RecordExpenditure> implements RecordExpenditureService{
	
	List<RecordExpenditure> list=null;
	
	@Override
	public Map<String, String> deleteRecordExpenditure(RecordExpenditure model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			RecordExpenditure recordExpenditure=(RecordExpenditure) getSession().get(RecordExpenditure.class, model.getId());
			map=delete(recordExpenditure);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			RecordExpenditure recordExpenditure=(RecordExpenditure) getSession().get(RecordExpenditure.class, model.getId());
			map=delete(recordExpenditure);
		}
		return map;
	}

	@Override
	public Map<String, String> updateRecordExpenditure(RecordExpenditure model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		getSession().beginTransaction();
		map=update(model);
		return map;
	}

	@Override
	public Map<String, String> addRecordExpenditure(RecordExpenditure model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		getSession().beginTransaction();
		map=save(model);
		return map;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecordExpenditure> getRecordExpenditure(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from record_expenditure where social_credit_code="+socialCreditCode);

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(RecordExpenditure.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(RecordExpenditure.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

}

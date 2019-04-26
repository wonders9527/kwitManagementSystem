package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataEmployeePosition;
import com.kwit.service.DataEmployeePositionService;

@Service("dataEmployeePositionService")
public class DataEmployeePositionServiceImpl extends BaseServiceImpl<DataEmployeePosition> implements DataEmployeePositionService{

	List<DataEmployeePosition> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataEmployeePosition> getEmployeePosition(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_employee_position where social_credit_code=");
		sql.append("'"+socialCreditCode+"'");

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataEmployeePosition.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataEmployeePosition.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> updateEmployeePosition(DataEmployeePosition model) {
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
	public Map<String, String> addEmployeePosition(DataEmployeePosition model) {
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
	public Map<String, String> deleteEmployeePosition(DataEmployeePosition model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataEmployeePosition dataEmployeePosition=(DataEmployeePosition) getSession().get(DataEmployeePosition.class, model.getId());
			map=delete(dataEmployeePosition);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataEmployeePosition dataEmployeePosition=(DataEmployeePosition) getSession().get(DataEmployeePosition.class, model.getId());
			map=delete(dataEmployeePosition);
		}
		
		return map;
	}

}

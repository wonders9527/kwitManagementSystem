package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataDepartmentInformation;
import com.kwit.service.DataDepartmentInformationService;

@Service("dataDepartmentInformationService")
public class DataDepartmentInformationServiceImpl extends BaseServiceImpl<DataDepartmentInformation> implements DataDepartmentInformationService{
	
	List<DataDepartmentInformation> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataDepartmentInformation> getDepartment(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_department_information where social_credit_code="+"'"+socialCreditCode+"'");

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataDepartmentInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataDepartmentInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> addDepartment(DataDepartmentInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		if(stransJudge()==1){
			map=save(model);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			map=save(model);
		}
		return map;	
	}

	@Override
	public Map<String, String> updateDepartment(DataDepartmentInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		if(stransJudge()==1){
			map=update(model);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			map=update(model);
		}
		return map;
	}

	@Override
	public Map<String, String> deleteDepartment(DataDepartmentInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataDepartmentInformation dataDepartmentInformation=(DataDepartmentInformation) getSession().get(DataDepartmentInformation.class, model.getId());
			map=delete(dataDepartmentInformation);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataDepartmentInformation dataProductInformation=(DataDepartmentInformation) getSession().get(DataDepartmentInformation.class, model.getId());
			map=delete(dataProductInformation);
		}
		return map;
	}

}

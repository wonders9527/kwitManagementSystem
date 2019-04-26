package com.kwit.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataEmployeeInformation;
import com.kwit.service.DataEmployeeInformationService;

@Service("dataEmployeeInformationService")
public class DataEmployeeInformationServiceImpl extends BaseServiceImpl<DataEmployeeInformation> implements DataEmployeeInformationService{

	List<DataEmployeeInformation> list = null;
	
	@Override
	public Map<String, String> uploadEmployeePicture(File upload, String uploadFileName, String uploadContentType) {
		Map<String, String> map=new HashMap<String, String>();
		map=uploadPicture(upload,uploadFileName,uploadContentType);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataEmployeeInformation> getEmployeeInformation(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_employee_information where social_credit_code=");
		sql.append("'"+socialCreditCode+"'");
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataEmployeeInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataEmployeeInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> addEmployeeInformation(DataEmployeeInformation model) {
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
	public Map<String, String> updateEmployeeInformation(DataEmployeeInformation model) {
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
	public Map<String, String> deleteEmployeeInformation(DataEmployeeInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataEmployeeInformation dataEmployeeInformation=(DataEmployeeInformation) getSession().get(DataEmployeeInformation.class, model.getId());
			map=delete(dataEmployeeInformation);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataEmployeeInformation dataEmployeeInformation=(DataEmployeeInformation) getSession().get(DataEmployeeInformation.class, model.getId());
			map=delete(dataEmployeeInformation);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataEmployeeInformation> getEmployeeInformationById(Integer id) {
		StringBuffer sql = new StringBuffer("select * from data_employee_information where id=");
		sql.append(id);
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataEmployeeInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataEmployeeInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

}

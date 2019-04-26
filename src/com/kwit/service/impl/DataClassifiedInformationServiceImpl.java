package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataClassifiedInformation;
import com.kwit.service.DataClassifiedInformationService;

@Service("dataClassifiedInformationService")
public class DataClassifiedInformationServiceImpl extends BaseServiceImpl<DataClassifiedInformation> implements DataClassifiedInformationService{
	
	List<DataClassifiedInformation> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataClassifiedInformation> getProductClassified(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_classified_information where social_credit_code=");
		sql.append("'"+socialCreditCode+"'");

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataClassifiedInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataClassifiedInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> addProductClassified(DataClassifiedInformation model) {
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
	public Map<String, String> updateProductClassified(DataClassifiedInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		list=getProductClassifiedById(model.getId());
		model.setSocialCreditCode(list.get(0).getSocialCreditCode());
		model.setStoreName(list.get(0).getStoreName());
		model.setCreateDate(timesTamp);
		
		if(stransJudge()==0){
			getSession().beginTransaction();
			map=update(model);
		}else if(stransJudge()==1){
			map=update(model);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	private List<DataClassifiedInformation> getProductClassifiedById(Integer id) {
		StringBuffer sql = new StringBuffer("select * from data_classified_information where id=");
		sql.append(id);
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataClassifiedInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataClassifiedInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> deleteProductClassified(DataClassifiedInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataClassifiedInformation dataClassifiedInformation=(DataClassifiedInformation) getSession().get(DataClassifiedInformation.class, model.getId());
			map=delete(dataClassifiedInformation);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataClassifiedInformation dataClassifiedInformation=(DataClassifiedInformation) getSession().get(DataClassifiedInformation.class, model.getId());
			map=delete(dataClassifiedInformation);
		}
		
		return map;
	}

}

package com.kwit.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataMemberInformation;
import com.kwit.service.DataMemberInformationService;

@Service("dataMemberInformationService")
public class DataMemberInformationServiceImpl extends BaseServiceImpl<DataMemberInformation> implements DataMemberInformationService{

	List<DataMemberInformation> list = null;
	
	@Override
	public Map<String, String> uploadMemberPicture(File upload, String uploadFileName, String uploadContentType) {
		Map<String, String> map=new HashMap<String, String>();
		map=uploadPicture(upload,uploadFileName,uploadContentType);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataMemberInformation> getMemberInformation(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_member_information where social_credit_code=");
		sql.append("'"+socialCreditCode+"'");
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> addMemberInformation(DataMemberInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		if(model.getFavorableAmount()==null){
			model.setFavorableAmount((double) 0);
		}
		
		if(model.getAccountBalance()==null){
			model.setAccountBalance((double) 0);
		}
		
		if(model.getHandselBalance()==null){
			model.setHandselBalance((double) 0);
		}
		
		if(model.getCumulativeConsumption()==null){
			model.setCumulativeConsumption((double) 0);
		}
		if(stransJudge()==0){
			getSession().beginTransaction();
			map=save(model);
		}else if(stransJudge()==1){
			map=save(model);
		}
		return map;	
	}

	@Override
	public Map<String, String> updateMemberInformation(DataMemberInformation model) {
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
	public Map<String, String> deleteMemberInformation(DataMemberInformation model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataMemberInformation dataMemberInformation=(DataMemberInformation) getSession().get(DataMemberInformation.class, model.getId());
			map=delete(dataMemberInformation);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataMemberInformation dataMemberInformation=(DataMemberInformation) getSession().get(DataMemberInformation.class, model.getId());
			map=delete(dataMemberInformation);
		}
		return map;
	}

	@Override
	public boolean editAccountBalance(int id, Double rechargeAmount) {
		Map<String, String> map=new HashMap<String, String>();
		boolean result = false;

		if(stransJudge()==1){
			DataMemberInformation dataMemberInformation=(DataMemberInformation) getSession().get(DataMemberInformation.class, id);
			dataMemberInformation.setAccountBalance(dataMemberInformation.getAccountBalance()+rechargeAmount);
			map=update(dataMemberInformation);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataMemberInformation dataMemberInformation=(DataMemberInformation) getSession().get(DataMemberInformation.class, id);
			dataMemberInformation.setAccountBalance(dataMemberInformation.getAccountBalance()+rechargeAmount);
			map=update(dataMemberInformation);
		}
		
		if(map.get("mark")=="1"){
			result=true;
		}else if(map.get("mark")=="0"){
			result=false;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataMemberInformation> getMemberInformationByPhone(String socialCreditCode, String memberPhone) {
		StringBuffer sql = new StringBuffer("select * from data_member_information where social_credit_code=");
		sql.append("'"+socialCreditCode+"'");
		sql.append(" and member_phone=");
		sql.append("'"+memberPhone+"'");
		System.out.println(sql);
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberInformation.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

}

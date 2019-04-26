package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataMemberGrade;
import com.kwit.service.DataMemberGradeService;

@Service("dataDataMemberGradeService")
public class DataMemberGradeServiceImpl extends BaseServiceImpl<DataMemberGrade> implements DataMemberGradeService{
	
	List<DataMemberGrade> list = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataMemberGrade> getMemberGrade(String socialCreditCode) {
		StringBuffer sql = new StringBuffer("select * from data_member_grade where social_credit_code=");
		sql.append("'"+socialCreditCode+"'");
		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberGrade.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberGrade.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> addMemberGrade(DataMemberGrade model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		List<DataMemberGrade> listMemberGradeByName=this.getMemberGradeByName(model);
	
		if(listMemberGradeByName.isEmpty()){
			if(stransJudge()==1){
				map=save(model);
			}else if(stransJudge()==0){
				getSession().beginTransaction();
				map=save(model);
			}
		}else{
			map.put("mark", "2");
			map.put("result", "此数据已存在");
		}
		
		return map;	
	}

	@SuppressWarnings("unchecked")
	public List<DataMemberGrade> getMemberGradeByName(DataMemberGrade model) {
		
		StringBuffer sql = new StringBuffer("select * from data_member_grade where social_credit_code=");
		sql.append("'"+model.getSocialCreditCode()+"'");
		sql.append( "and grade_name="+"'"+model.getGradeName()+"'" );

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberGrade.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataMemberGrade.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}
	
	@Override
	public Map<String, String> updateMemberGrade(DataMemberGrade model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		List<DataMemberGrade> listMemberGradeByName=this.getMemberGradeByName(model);
		if(listMemberGradeByName.isEmpty()){
			if(stransJudge()==1){
				map=update(model);
			}else if(stransJudge()==0){
				getSession().beginTransaction();
				map=update(model);
			}
		}else{
			map.put("mark", "2");
			map.put("result", "此数据已存在");
		}
		return map;
	}

	@Override
	public Map<String, String> deleteMemberGrade(DataMemberGrade model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataMemberGrade dataMemberGrade=(DataMemberGrade) getSession().get(DataMemberGrade.class, model.getId());
			map=delete(dataMemberGrade);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataMemberGrade dataMemberGrade=(DataMemberGrade) getSession().get(DataMemberGrade.class, model.getId());
			map=delete(dataMemberGrade);
		}
		return map;
	}


}

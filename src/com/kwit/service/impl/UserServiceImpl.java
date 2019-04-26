package com.kwit.service.impl;

import java.util.List;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import com.kwit.model.UserTable;
import com.kwit.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserTable> implements UserService{
	
	private Transaction strans;
	
	private List<UserTable> userList;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserTable> getAll() {
		String sql="select * from user_table";
		getSession().beginTransaction();
		List<UserTable> list=getSession().createSQLQuery(sql).addEntity(UserTable.class).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserTable> login(String userName, String password) {
		
		StringBuffer sql = new StringBuffer("select * from user_table where user_name='"+userName+"'and password='"+password+"'");
		
		int strans=stransJudge();
		
		if(strans==1){
			try{
				userList= getSession().createSQLQuery(sql.toString()).addEntity(UserTable.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(strans==0){
			try{
				getSession().beginTransaction();
				userList= getSession().createSQLQuery(sql.toString()).addEntity(UserTable.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return userList;
	}

	@Override
	public List<UserTable> getUser(String userName, String passWord) {
		return null;
	}

	public Transaction getStrans() {
		return strans;
	}

	public void setStrans(Transaction strans) {
		this.strans = strans;
	}

}

package com.kwit.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.kwit.model.DataStockProduct;
import com.kwit.service.DataStockProductService;

@Service("dataStockProductService")
public class DataStockProductServiceImpl extends BaseServiceImpl<DataStockProduct> implements DataStockProductService{
	
	List<DataStockProduct> list = null;
	
	@Override
	public Map<String, String> saveDataStockProduct(DataStockProduct model) {
		Map<String, String> map=new HashMap<String, String>();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		getSession().beginTransaction();
		map=save(model);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataStockProduct> getDataStockProduct(String socialCreditCode) {
		
		StringBuffer sql = new StringBuffer("select * from data_stock_product where social_credit_code="+socialCreditCode);

		if(stransJudge()==0){
			try{
				getSession().beginTransaction();
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataStockProduct.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}else if(stransJudge()==1){
			try{
				list=getSession().createSQLQuery(sql.toString()).addEntity(DataStockProduct.class).list();
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				getSession().getTransaction().commit();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> updateDataStockProduct(DataStockProduct model) {
		Map<String, String> map=new HashMap<String, String>();
		getSession().beginTransaction();
		Timestamp timesTamp = new Timestamp(new Date().getTime());
		model.setCreateDate(timesTamp);
		map=update(model);
		return map;
	}

	@Override
	public Map<String, String> deleteDataStockProduct(DataStockProduct model) {
		Map<String, String> map=new HashMap<String, String>();
		if(stransJudge()==1){
			DataStockProduct dataStockProduct=(DataStockProduct) getSession().get(DataStockProduct.class, model.getId());
			map=delete(dataStockProduct);
		}else if(stransJudge()==0){
			getSession().beginTransaction();
			DataStockProduct dataStockProduct=(DataStockProduct) getSession().get(DataStockProduct.class, model.getId());
			map=delete(dataStockProduct);
		}
		return map;
	}

}

package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.DataStockProduct;

public interface DataStockProductService {

	Map<String, String> saveDataStockProduct(DataStockProduct model);

	List<DataStockProduct> getDataStockProduct(String socialCreditCode);

	Map<String, String> updateDataStockProduct(DataStockProduct model);

	Map<String, String> deleteDataStockProduct(DataStockProduct model);

}

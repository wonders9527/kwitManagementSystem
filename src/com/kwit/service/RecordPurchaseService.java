package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.RecordPurchase;

public interface RecordPurchaseService {

	List<RecordPurchase> getPurchase(String string);

	Map<String, String> addPurchase(RecordPurchase model);

	Map<String, String> updatePurchase(RecordPurchase model);

	Map<String, String> deletePurchase(RecordPurchase model);

}

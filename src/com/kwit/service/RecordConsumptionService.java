package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.RecordConsumption;

public interface RecordConsumptionService {

	Map<String, String> saveRecordConsumption(RecordConsumption model);

	List<RecordConsumption> getRecordConsumption(String socialCreditCode);

	Map<String, String> updateRecordConsumption(RecordConsumption model);

	Map<String, String> deleteRecordConsumption(RecordConsumption model);

}

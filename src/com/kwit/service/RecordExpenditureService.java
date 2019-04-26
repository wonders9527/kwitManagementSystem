package com.kwit.service;

import java.util.List;
import java.util.Map;
import com.kwit.model.RecordExpenditure;

public interface RecordExpenditureService {

	Map<String, String> deleteRecordExpenditure(RecordExpenditure model);

	Map<String, String> updateRecordExpenditure(RecordExpenditure model);

	Map<String, String> addRecordExpenditure(RecordExpenditure model);

	List<RecordExpenditure> getRecordExpenditure(String socialCreditCode);

}

package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.RecordMemberRecharge;

public interface RecordMemberRechargeService {

	List<RecordMemberRecharge> getRecordMemberRecharge(String socialCreditCode);

	Map<String, String> updateRecordMemberRecharge(RecordMemberRecharge model);

	Map<String, String> deleteRecordMemberRecharge(RecordMemberRecharge model);

	Map<String, String> addRecordMemberRecharge(RecordMemberRecharge model,int memberId);

}

package com.kwit.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.kwit.model.DataRechargeInformation;

public interface DataRechargeInformationService {
	
    Map<String, String> saveRecharge(DataRechargeInformation model);

	Map<String, String> deleteRecharge(DataRechargeInformation model);

	Map<String, String> updateRecharge(DataRechargeInformation model);

	List<DataRechargeInformation> getRecharge(String socialCreditCode);

	Map<String, String> uploadPictureRecharge(File upload, String uploadFileName, String uploadContentType);
}

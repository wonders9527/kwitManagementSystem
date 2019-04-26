package com.kwit.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.kwit.model.DataMemberInformation;

public interface DataMemberInformationService {

	Map<String, String> uploadMemberPicture(File upload, String uploadFileName, String uploadContentType);

	List<DataMemberInformation> getMemberInformation(String socialCreditCode);

	Map<String, String> addMemberInformation(DataMemberInformation model);

	Map<String, String> updateMemberInformation(DataMemberInformation model);

	Map<String, String> deleteMemberInformation(DataMemberInformation model);
	
	boolean editAccountBalance(int id,Double double1 );

	List<DataMemberInformation> getMemberInformationByPhone(String socialCreditCode, String memberPhone);

}

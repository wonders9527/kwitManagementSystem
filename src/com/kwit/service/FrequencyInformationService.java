package com.kwit.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import com.kwit.model.FrequencyInformation;

public interface FrequencyInformationService {
	Map<String, String> addFrequencyInformation(FrequencyInformation model);

	List<FrequencyInformation> getFrequencyInformation(String socialCreditCode);

	Map<String, String> uploadPicture(File upload, String uploadFileName, String uploadContentType);

	Map<String, String> deleteFrequencyInformation(FrequencyInformation model);

	Map<String, String> updateFrequencyInformation(FrequencyInformation model);
}

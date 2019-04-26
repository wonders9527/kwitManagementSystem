package com.kwit.service;

import java.util.List;
import java.util.Map;
import com.kwit.model.DataDepartmentInformation;

public interface DataDepartmentInformationService {

	List<DataDepartmentInformation> getDepartment(String socialCreditCode);
	Map<String, String> addDepartment(DataDepartmentInformation model);
	Map<String, String> updateDepartment(DataDepartmentInformation model);
	Map<String, String> deleteDepartment(DataDepartmentInformation model);
	
}

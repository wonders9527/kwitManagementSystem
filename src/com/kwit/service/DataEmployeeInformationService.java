package com.kwit.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.kwit.model.DataEmployeeInformation;

public interface DataEmployeeInformationService {

	Map<String, String> uploadEmployeePicture(File upload, String uploadFileName, String uploadContentType);

	List<DataEmployeeInformation> getEmployeeInformation(String socialCreditCode);

	Map<String, String> addEmployeeInformation(DataEmployeeInformation model);

	Map<String, String> updateEmployeeInformation(DataEmployeeInformation model);

	Map<String, String> deleteEmployeeInformation(DataEmployeeInformation model);

	List<DataEmployeeInformation> getEmployeeInformationById(Integer id);

}

package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.DataEmployeePosition;

public interface DataEmployeePositionService {

	List<DataEmployeePosition> getEmployeePosition(String socialCreditCode);

	Map<String, String> updateEmployeePosition(DataEmployeePosition model);

	Map<String, String> addEmployeePosition(DataEmployeePosition model);

	Map<String, String> deleteEmployeePosition(DataEmployeePosition model);

}

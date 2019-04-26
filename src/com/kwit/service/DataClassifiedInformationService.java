package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.DataClassifiedInformation;

public interface DataClassifiedInformationService {

	List<DataClassifiedInformation> getProductClassified(String socialCreditCode);

	Map<String, String> addProductClassified(DataClassifiedInformation model);

	Map<String, String> updateProductClassified(DataClassifiedInformation model);

	Map<String, String> deleteProductClassified(DataClassifiedInformation model);

}

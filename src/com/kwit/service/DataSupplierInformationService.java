package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.DataSupplierInformation;

public interface DataSupplierInformationService {

	List<DataSupplierInformation> getSupplierInfor(String socialCreditCode);

	Map<String, String> addSupplierInfor(DataSupplierInformation model);

	Map<String, String> updateSupplierInfor(DataSupplierInformation model);

	Map<String, String> deleteSupplierInfor(DataSupplierInformation model);

}

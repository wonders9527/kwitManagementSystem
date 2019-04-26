package com.kwit.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import com.kwit.model.DataProductInformation;


public interface DataProductInformationService {

	Map<String, String> saveProductInfor(DataProductInformation model);

	List<DataProductInformation> getProductInfor(String socialCreditCode);

	Map<String, String> deleteProductInfor(DataProductInformation model);

	Map<String, String> updateProductInfor(DataProductInformation model);


	Map<String, String> uploadPicturePro(File upload, String uploadFileName, String uploadContentType);

	List<DataProductInformation> getProductInforById(Integer id);

	List<DataProductInformation> getProductInforLimt(String socialCreditCode, int pageSize, int pageNumber);

}

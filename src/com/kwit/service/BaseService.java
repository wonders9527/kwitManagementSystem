package com.kwit.service;

import java.io.File;
import java.util.Map;

public interface BaseService<T> {

	Map<String, String> save(T t);
	
	Map<String, String> delete(T t);
	
	Map<String, String> update(T t);
	
	Map<String, String> uploadPicture(File upload, String uploadFileName, String uploadContentType);
	
	int stransJudge();

}

package com.kwit.service;

import java.util.List;
import java.util.Map;

import com.kwit.model.DataMemberGrade;

public interface DataMemberGradeService {

	List<DataMemberGrade> getMemberGrade(String string);

	Map<String, String> addMemberGrade(DataMemberGrade model);

	Map<String, String> updateMemberGrade(DataMemberGrade model);

	Map<String, String> deleteMemberGrade(DataMemberGrade model);



}

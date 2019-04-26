package com.kwit.model;

import java.sql.Timestamp;
import java.util.Date;

public class DataEmployeeInformation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	@Override
	public String toString() {
		return "DataEmployeeInformation [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName="
				+ storeName + ", employeeName=" + employeeName + ", gender=" + gender + ", appellation=" + appellation
				+ ", contactNumber=" + contactNumber + ", idNumber=" + idNumber + ", dateBirth=" + dateBirth
				+ ", height=" + height + ", politicalStatus=" + politicalStatus + ", employmentStatus="
				+ employmentStatus + ", marriageStatus=" + marriageStatus + ", birthplace=" + birthplace
				+ ", education=" + education + ", profession=" + profession + ", graduatedSchool=" + graduatedSchool
				+ ", graduatedTime=" + graduatedTime + ", employeeIntroduction=" + employeeIntroduction
				+ ", employeePicture=" + employeePicture + ", homeAddress=" + homeAddress + ", department=" + department
				+ ", post=" + post + ", healthStatus=" + healthStatus + ", remark=" + remark + ", createDate="
				+ createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}
	
	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String employeeName;
	private String gender;
	private String appellation;
	private String contactNumber;
	private String idNumber;
	private Date dateBirth;
	private String height;
	private String politicalStatus;
	private String employmentStatus;
	private String marriageStatus;
	private String birthplace;
	private String education;
	private String profession;
	private String graduatedSchool;
	private Date graduatedTime;
	private String employeeIntroduction;
	private String employeePicture;
	private String homeAddress;
	private String department;
	private String post;
	private String healthStatus;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public DataEmployeeInformation() {
	}

	/** minimal constructor */
	public DataEmployeeInformation(String socialCreditCode, String storeName, String employeeName, String gender,
			Date dateBirth, Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.employeeName = employeeName;
		this.gender = gender;
		this.dateBirth = dateBirth;
		this.createDate = createDate;
	}

	/** full constructor */
	public DataEmployeeInformation(String socialCreditCode, String storeName, String employeeName, String gender,
			String appellation, String contactNumber, String idNumber, Date dateBirth, String height,
			String politicalStatus, String employmentStatus, String marriageStatus, String birthplace, String education,
			String profession, String graduatedSchool, Date graduatedTime, String employeeIntroduction,
			String employeePicture, String homeAddress, String department, String post, String healthStatus,
			String remark, Timestamp createDate, String temp1, String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.employeeName = employeeName;
		this.gender = gender;
		this.appellation = appellation;
		this.contactNumber = contactNumber;
		this.idNumber = idNumber;
		this.dateBirth = dateBirth;
		this.height = height;
		this.politicalStatus = politicalStatus;
		this.employmentStatus = employmentStatus;
		this.marriageStatus = marriageStatus;
		this.birthplace = birthplace;
		this.education = education;
		this.profession = profession;
		this.graduatedSchool = graduatedSchool;
		this.graduatedTime = graduatedTime;
		this.employeeIntroduction = employeeIntroduction;
		this.employeePicture = employeePicture;
		this.homeAddress = homeAddress;
		this.department = department;
		this.post = post;
		this.healthStatus = healthStatus;
		this.remark = remark;
		this.createDate = createDate;
		this.temp1 = temp1;
		this.temp2 = temp2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSocialCreditCode() {
		return this.socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAppellation() {
		return this.appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getDateBirth() {
		return this.dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getEmploymentStatus() {
		return this.employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getMarriageStatus() {
		return this.marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getGraduatedSchool() {
		return this.graduatedSchool;
	}

	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}

	public Date getGraduatedTime() {
		return this.graduatedTime;
	}

	public void setGraduatedTime(Date graduatedTime) {
		this.graduatedTime = graduatedTime;
	}

	public String getEmployeeIntroduction() {
		return this.employeeIntroduction;
	}

	public void setEmployeeIntroduction(String employeeIntroduction) {
		this.employeeIntroduction = employeeIntroduction;
	}

	public String getEmployeePicture() {
		return this.employeePicture;
	}

	public void setEmployeePicture(String employeePicture) {
		this.employeePicture = employeePicture;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getHealthStatus() {
		return this.healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getTemp1() {
		return this.temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return this.temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

}
package com.kwit.model;

import java.sql.Timestamp;

public class DataMemberInformation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "DataMemberInformation [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", memberName=" + memberName + ", memberPhone=" + memberPhone + ", memberSex=" + memberSex
				+ ", memberDateBirth=" + memberDateBirth + ", memberIdnumber=" + memberIdnumber + ", memberPassword="
				+ memberPassword + ", memberAddress=" + memberAddress + ", memberGrade=" + memberGrade
				+ ", memberOrganization=" + memberOrganization + ", memberIntegral=" + memberIntegral
				+ ", memberSource=" + memberSource + ", favorableAmount=" + favorableAmount + ", accountBalance="
				+ accountBalance + ", handselBalance=" + handselBalance + ", cumulativeConsumption="
				+ cumulativeConsumption + ", memberAvatar=" + memberAvatar + ", remark=" + remark + ", createDate="
				+ createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}
	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String memberName;
	private String memberPhone;
	private String memberSex;
	private String memberDateBirth;
	private String memberIdnumber;
	private String memberPassword;
	private String memberAddress;
	private String memberGrade;
	private String memberOrganization;
	private String memberIntegral;
	private String memberSource;
	private Double favorableAmount;
	private Double accountBalance;
	private Double handselBalance;
	private Double cumulativeConsumption;
	private String memberAvatar;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public DataMemberInformation() {
	}

	/** minimal constructor */
	public DataMemberInformation(String socialCreditCode, String storeName, String memberName, String memberPhone,
			String memberIdnumber, String memberPassword, Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberIdnumber = memberIdnumber;
		this.memberPassword = memberPassword;
		this.createDate = createDate;
	}

	/** full constructor */
	public DataMemberInformation(String socialCreditCode, String storeName, String memberName, String memberPhone,
			String memberSex, String memberDateBirth, String memberIdnumber, String memberPassword,
			String memberAddress, String memberGrade, String memberOrganization, String memberIntegral,
			String memberSource, Double favorableAmount, Double accountBalance, Double handselBalance,
			Double cumulativeConsumption, String memberAvatar, String remark, Timestamp createDate, String temp1,
			String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberSex = memberSex;
		this.memberDateBirth = memberDateBirth;
		this.memberIdnumber = memberIdnumber;
		this.memberPassword = memberPassword;
		this.memberAddress = memberAddress;
		this.memberGrade = memberGrade;
		this.memberOrganization = memberOrganization;
		this.memberIntegral = memberIntegral;
		this.memberSource = memberSource;
		this.favorableAmount = favorableAmount;
		this.accountBalance = accountBalance;
		this.handselBalance = handselBalance;
		this.cumulativeConsumption = cumulativeConsumption;
		this.memberAvatar = memberAvatar;
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

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return this.memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberSex() {
		return this.memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public String getMemberDateBirth() {
		return this.memberDateBirth;
	}

	public void setMemberDateBirth(String memberDateBirth) {
		this.memberDateBirth = memberDateBirth;
	}

	public String getMemberIdnumber() {
		return this.memberIdnumber;
	}

	public void setMemberIdnumber(String memberIdnumber) {
		this.memberIdnumber = memberIdnumber;
	}

	public String getMemberPassword() {
		return this.memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberAddress() {
		return this.memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberGrade() {
		return this.memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getMemberOrganization() {
		return this.memberOrganization;
	}

	public void setMemberOrganization(String memberOrganization) {
		this.memberOrganization = memberOrganization;
	}

	public String getMemberIntegral() {
		return this.memberIntegral;
	}

	public void setMemberIntegral(String memberIntegral) {
		this.memberIntegral = memberIntegral;
	}

	public String getMemberSource() {
		return this.memberSource;
	}

	public void setMemberSource(String memberSource) {
		this.memberSource = memberSource;
	}

	public Double getFavorableAmount() {
		return this.favorableAmount;
	}

	public void setFavorableAmount(Double favorableAmount) {
		this.favorableAmount = favorableAmount;
	}

	public Double getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getHandselBalance() {
		return this.handselBalance;
	}

	public void setHandselBalance(Double handselBalance) {
		this.handselBalance = handselBalance;
	}

	public Double getCumulativeConsumption() {
		return this.cumulativeConsumption;
	}

	public void setCumulativeConsumption(Double cumulativeConsumption) {
		this.cumulativeConsumption = cumulativeConsumption;
	}

	public String getMemberAvatar() {
		return this.memberAvatar;
	}

	public void setMemberAvatar(String memberAvatar) {
		this.memberAvatar = memberAvatar;
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
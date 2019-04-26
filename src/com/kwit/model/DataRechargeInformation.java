package com.kwit.model;

import java.sql.Timestamp;

public class DataRechargeInformation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		
		return "DataRechargeInformation [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName="
				+ storeName + ", storeIndustry=" + storeIndustry + ", storeAddress=" + storeAddress + ", contactPeople="
				+ contactPeople + ", contactPhone=" + contactPhone + ", storeIntroduction=" + storeIntroduction
				+ ", attendantPhone=" + attendantPhone + ", operateState=" + operateState + ", storePicture="
				+ storePicture + ", storeLogo=" + storeLogo + ", remark=" + remark + ", createDate=" + createDate
				+ ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String storeIndustry;
	private String storeAddress;
	private String contactPeople;
	private String contactPhone;
	private String storeIntroduction;
	private String attendantPhone;
	private String operateState;
	private String storePicture;
	private String storeLogo;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public DataRechargeInformation() {
	}

	/** minimal constructor */
	public DataRechargeInformation(String socialCreditCode, String storeName, Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.createDate = createDate;
	}

	/** full constructor */
	public DataRechargeInformation(String socialCreditCode, String storeName, String storeIndustry, String storeAddress,
			String contactPeople, String contactPhone, String storeIntroduction, String attendantPhone,
			String operateState, String storePicture, String storeLogo, String remark, Timestamp createDate,
			String temp1, String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.storeIndustry = storeIndustry;
		this.storeAddress = storeAddress;
		this.contactPeople = contactPeople;
		this.contactPhone = contactPhone;
		this.storeIntroduction = storeIntroduction;
		this.attendantPhone = attendantPhone;
		this.operateState = operateState;
		this.storePicture = storePicture;
		this.storeLogo = storeLogo;
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

	public String getStoreIndustry() {
		return this.storeIndustry;
	}

	public void setStoreIndustry(String storeIndustry) {
		this.storeIndustry = storeIndustry;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getContactPeople() {
		return this.contactPeople;
	}

	public void setContactPeople(String contactPeople) {
		this.contactPeople = contactPeople;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getStoreIntroduction() {
		return this.storeIntroduction;
	}

	public void setStoreIntroduction(String storeIntroduction) {
		this.storeIntroduction = storeIntroduction;
	}

	public String getAttendantPhone() {
		return this.attendantPhone;
	}

	public void setAttendantPhone(String attendantPhone) {
		this.attendantPhone = attendantPhone;
	}

	public String getOperateState() {
		return this.operateState;
	}

	public void setOperateState(String operateState) {
		this.operateState = operateState;
	}

	public String getStorePicture() {
		return this.storePicture;
	}

	public void setStorePicture(String storePicture) {
		this.storePicture = storePicture;
	}

	public String getStoreLogo() {
		return this.storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
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
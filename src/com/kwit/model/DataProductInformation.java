package com.kwit.model;

import java.sql.Timestamp;

/**
 * DataProductInformation entity. @author MyEclipse Persistence Tools
 */

public class DataProductInformation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "DataProductInformation [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName="
				+ storeName + ", commodityClassification=" + commodityClassification + ", commodityName="
				+ commodityName + ", commodityCode=" + commodityCode + ", commoditySpecification="
				+ commoditySpecification + ", specificationName=" + specificationName + ", specificationContent="
				+ specificationContent + ", commodityPrice=" + commodityPrice + ", commodityLabel=" + commodityLabel
				+ ", commodityBarCode=" + commodityBarCode + ", commodityPicture=" + commodityPicture
				+ ", commodityIntroduction=" + commodityIntroduction + ", commodityDescription=" + commodityDescription
				+ ", commodityShelfStatus=" + commodityShelfStatus + ", mallDisplayStatus=" + mallDisplayStatus
				+ ", participationDiscountStatus=" + participationDiscountStatus + ", employeeCommissionStatus="
				+ employeeCommissionStatus + ", commissionAmount=" + commissionAmount + ", remark=" + remark
				+ ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String commodityClassification;
	private String commodityName;
	private String commodityCode;
	private String commoditySpecification;
	private String specificationName;
	private String specificationContent;
	private String commodityPrice;
	private String commodityLabel;
	private String commodityBarCode;
	private String commodityPicture;
	private String commodityIntroduction;
	private String commodityDescription;
	private String commodityShelfStatus;
	private String mallDisplayStatus;
	private String participationDiscountStatus;
	private String employeeCommissionStatus;
	private String commissionAmount;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public DataProductInformation() {
	}

	/** minimal constructor */
	public DataProductInformation(String socialCreditCode, String commodityName, String commodityPrice) {
		this.socialCreditCode = socialCreditCode;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
	}

	/** full constructor */
	public DataProductInformation(String socialCreditCode, String storeName, String commodityClassification,
			String commodityName, String commodityCode, String commoditySpecification, String specificationName,
			String specificationContent, String commodityPrice, String commodityLabel, String commodityBarCode,
			String commodityPicture, String commodityIntroduction, String commodityDescription,
			String commodityShelfStatus, String mallDisplayStatus, String participationDiscountStatus,
			String employeeCommissionStatus, String commissionAmount, String remark, Timestamp createDate, String temp1,
			String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.commodityClassification = commodityClassification;
		this.commodityName = commodityName;
		this.commodityCode = commodityCode;
		this.commoditySpecification = commoditySpecification;
		this.specificationName = specificationName;
		this.specificationContent = specificationContent;
		this.commodityPrice = commodityPrice;
		this.commodityLabel = commodityLabel;
		this.commodityBarCode = commodityBarCode;
		this.commodityPicture = commodityPicture;
		this.commodityIntroduction = commodityIntroduction;
		this.commodityDescription = commodityDescription;
		this.commodityShelfStatus = commodityShelfStatus;
		this.mallDisplayStatus = mallDisplayStatus;
		this.participationDiscountStatus = participationDiscountStatus;
		this.employeeCommissionStatus = employeeCommissionStatus;
		this.commissionAmount = commissionAmount;
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

	public String getCommodityClassification() {
		return this.commodityClassification;
	}

	public void setCommodityClassification(String commodityClassification) {
		this.commodityClassification = commodityClassification;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityCode() {
		return this.commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getCommoditySpecification() {
		return this.commoditySpecification;
	}

	public void setCommoditySpecification(String commoditySpecification) {
		this.commoditySpecification = commoditySpecification;
	}

	public String getSpecificationName() {
		return this.specificationName;
	}

	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}

	public String getSpecificationContent() {
		return this.specificationContent;
	}

	public void setSpecificationContent(String specificationContent) {
		this.specificationContent = specificationContent;
	}

	public String getCommodityPrice() {
		return this.commodityPrice;
	}

	public void setCommodityPrice(String commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityLabel() {
		return this.commodityLabel;
	}

	public void setCommodityLabel(String commodityLabel) {
		this.commodityLabel = commodityLabel;
	}

	public String getCommodityBarCode() {
		return this.commodityBarCode;
	}

	public void setCommodityBarCode(String commodityBarCode) {
		this.commodityBarCode = commodityBarCode;
	}

	public String getCommodityPicture() {
		return this.commodityPicture;
	}

	public void setCommodityPicture(String commodityPicture) {
		this.commodityPicture = commodityPicture;
	}

	public String getCommodityIntroduction() {
		return this.commodityIntroduction;
	}

	public void setCommodityIntroduction(String commodityIntroduction) {
		this.commodityIntroduction = commodityIntroduction;
	}

	public String getCommodityDescription() {
		return this.commodityDescription;
	}

	public void setCommodityDescription(String commodityDescription) {
		this.commodityDescription = commodityDescription;
	}

	public String getCommodityShelfStatus() {
		return this.commodityShelfStatus;
	}

	public void setCommodityShelfStatus(String commodityShelfStatus) {
		this.commodityShelfStatus = commodityShelfStatus;
	}

	public String getMallDisplayStatus() {
		return this.mallDisplayStatus;
	}

	public void setMallDisplayStatus(String mallDisplayStatus) {
		this.mallDisplayStatus = mallDisplayStatus;
	}

	public String getParticipationDiscountStatus() {
		return this.participationDiscountStatus;
	}

	public void setParticipationDiscountStatus(String participationDiscountStatus) {
		this.participationDiscountStatus = participationDiscountStatus;
	}

	public String getEmployeeCommissionStatus() {
		return this.employeeCommissionStatus;
	}

	public void setEmployeeCommissionStatus(String employeeCommissionStatus) {
		this.employeeCommissionStatus = employeeCommissionStatus;
	}

	public String getCommissionAmount() {
		return this.commissionAmount;
	}

	public void setCommissionAmount(String commissionAmount) {
		this.commissionAmount = commissionAmount;
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
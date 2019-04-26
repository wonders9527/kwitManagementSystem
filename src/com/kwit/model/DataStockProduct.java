package com.kwit.model;

import java.sql.Timestamp;

/**
 * DataStockProduct entity. 
 * @author MyEclipse Persistence Tools
 */

public class DataStockProduct implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "DataStockProduct [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", commodityClassification=" + commodityClassification + ", commodityName=" + commodityName
				+ ", commoditySpecification=" + commoditySpecification + ", unit=" + unit + ", stockQuantity="
				+ stockQuantity + ", storageTime=" + storageTime + ", countingTime=" + countingTime + ", remark="
				+ remark + ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String commodityClassification;
	private String commodityName;
	private String commoditySpecification;
	private String unit;
	private String stockQuantity;
	private Timestamp storageTime;
	private Timestamp countingTime;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public DataStockProduct() {
	}

	/** minimal constructor */
	public DataStockProduct(String socialCreditCode, String storeName, String commodityClassification,
			String commodityName, Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.commodityClassification = commodityClassification;
		this.commodityName = commodityName;
		this.createDate = createDate;
	}

	/** full constructor */
	public DataStockProduct(String socialCreditCode, String storeName, String commodityClassification,
			String commodityName, String commoditySpecification, String unit, String stockQuantity,
			Timestamp storageTime, Timestamp countingTime, String remark, Timestamp createDate, String temp1,
			String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.commodityClassification = commodityClassification;
		this.commodityName = commodityName;
		this.commoditySpecification = commoditySpecification;
		this.unit = unit;
		this.stockQuantity = stockQuantity;
		this.storageTime = storageTime;
		this.countingTime = countingTime;
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

	public String getCommoditySpecification() {
		return this.commoditySpecification;
	}

	public void setCommoditySpecification(String commoditySpecification) {
		this.commoditySpecification = commoditySpecification;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Timestamp getStorageTime() {
		return this.storageTime;
	}

	public void setStorageTime(Timestamp storageTime) {
		this.storageTime = storageTime;
	}

	public Timestamp getCountingTime() {
		return this.countingTime;
	}

	public void setCountingTime(Timestamp countingTime) {
		this.countingTime = countingTime;
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
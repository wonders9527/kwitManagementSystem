package com.kwit.model;

import java.sql.Timestamp;

/**
 * DataSupplierInformation entity. @author MyEclipse Persistence Tools
 */

public class DataSupplierInformation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "DataSupplierInformation [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName="
				+ storeName + ", supplierName=" + supplierName + ", supplierCode=" + supplierCode
				+ ", supplierContactName=" + supplierContactName + ", supplierContactNamber=" + supplierContactNamber
				+ ", remark=" + remark + ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}
	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String supplierName;
	private String supplierCode;
	private String supplierContactName;
	private String supplierContactNamber;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public DataSupplierInformation() {
	}

	/** minimal constructor */
	public DataSupplierInformation(String socialCreditCode, String storeName, String supplierName,
			Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.supplierName = supplierName;
		this.createDate = createDate;
	}

	/** full constructor */
	public DataSupplierInformation(String socialCreditCode, String storeName, String supplierName, String supplierCode,
			String supplierContactName, String supplierContactNamber, String remark, Timestamp createDate, String temp1,
			String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.supplierName = supplierName;
		this.supplierCode = supplierCode;
		this.supplierContactName = supplierContactName;
		this.supplierContactNamber = supplierContactNamber;
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

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierContactName() {
		return this.supplierContactName;
	}

	public void setSupplierContactName(String supplierContactName) {
		this.supplierContactName = supplierContactName;
	}

	public String getSupplierContactNamber() {
		return this.supplierContactNamber;
	}

	public void setSupplierContactNamber(String supplierContactNamber) {
		this.supplierContactNamber = supplierContactNamber;
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
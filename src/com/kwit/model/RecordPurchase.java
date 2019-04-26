package com.kwit.model;

import java.sql.Timestamp;

public class RecordPurchase implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "RecordPurchase [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", documentNumber=" + documentNumber + ", supplierCode=" + supplierCode + ", commodityName="
				+ commodityName + ", unit=" + unit + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", total="
				+ total + ", actualHarvest=" + actualHarvest + ", purchaseAmount=" + purchaseAmount + ", paymentMethod="
				+ paymentMethod + ", inboundStatus=" + inboundStatus + ", purchaseTime=" + purchaseTime + ", otherFee="
				+ otherFee + ", remark=" + remark + ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2="
				+ temp2 + "]";
	}
	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String documentNumber;
	private String supplierCode;
	private String commodityName;
	private String unit;
	private String unitPrice;
	private String quantity;
	private String total;
	private String actualHarvest;
	private String purchaseAmount;
	private String paymentMethod;
	private String inboundStatus;
	private Timestamp purchaseTime;
	private String otherFee;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public RecordPurchase() {
	}

	/** minimal constructor */
	public RecordPurchase(String socialCreditCode, String storeName, String documentNumber, String supplierCode,
			String commodityName, String purchaseAmount, Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.documentNumber = documentNumber;
		this.supplierCode = supplierCode;
		this.commodityName = commodityName;
		this.purchaseAmount = purchaseAmount;
		this.createDate = createDate;
	}

	/** full constructor */
	public RecordPurchase(String socialCreditCode, String storeName, String documentNumber, String supplierCode,
			String commodityName, String unit, String unitPrice, String quantity, String total, String actualHarvest,
			String purchaseAmount, String paymentMethod, String inboundStatus, Timestamp purchaseTime, String otherFee,
			String remark, Timestamp createDate, String temp1, String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.documentNumber = documentNumber;
		this.supplierCode = supplierCode;
		this.commodityName = commodityName;
		this.unit = unit;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.total = total;
		this.actualHarvest = actualHarvest;
		this.purchaseAmount = purchaseAmount;
		this.paymentMethod = paymentMethod;
		this.inboundStatus = inboundStatus;
		this.purchaseTime = purchaseTime;
		this.otherFee = otherFee;
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

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getActualHarvest() {
		return this.actualHarvest;
	}

	public void setActualHarvest(String actualHarvest) {
		this.actualHarvest = actualHarvest;
	}

	public String getPurchaseAmount() {
		return this.purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getInboundStatus() {
		return this.inboundStatus;
	}

	public void setInboundStatus(String inboundStatus) {
		this.inboundStatus = inboundStatus;
	}

	public Timestamp getPurchaseTime() {
		return this.purchaseTime;
	}

	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public String getOtherFee() {
		return this.otherFee;
	}

	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
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
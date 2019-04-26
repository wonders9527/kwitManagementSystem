package com.kwit.model;

import java.sql.Timestamp;


public class RecordProductConsumption  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "RecordProductConsumption [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName="
				+ storeName + ", number=" + number + ", productClassification=" + productClassification
				+ ", productName=" + productName + ", productSpecification=" + productSpecification
				+ ", productOriginalPrice=" + productOriginalPrice + ", discountPrice=" + discountPrice + ", quantity="
				+ quantity + ", amount=" + amount + ", status=" + status + ", remark=" + remark + ", createDate="
				+ createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

	private Integer id;
     private String socialCreditCode;
     private String storeName;
     private String number;
     private String productClassification;
     private String productName;
     private String productSpecification;
     private String productOriginalPrice;
     private String discountPrice;
     private String quantity;
     private String amount;
     private String status;
     private String remark;
     private Timestamp createDate;
     private String temp1;
     private String temp2;


    // Constructors

    /** default constructor */
    public RecordProductConsumption() {
    }

	/** minimal constructor */
    public RecordProductConsumption(String socialCreditCode, String storeName, String number, String productClassification, String productName, String productSpecification, String productOriginalPrice, String discountPrice, String quantity, String amount, String status, Timestamp createDate) {
        this.socialCreditCode = socialCreditCode;
        this.storeName = storeName;
        this.number = number;
        this.productClassification = productClassification;
        this.productName = productName;
        this.productSpecification = productSpecification;
        this.productOriginalPrice = productOriginalPrice;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.createDate = createDate;
    }
    
    /** full constructor */
    public RecordProductConsumption(String socialCreditCode, String storeName, String number, String productClassification, String productName, String productSpecification, String productOriginalPrice, String discountPrice, String quantity, String amount, String status, String remark, Timestamp createDate, String temp1, String temp2) {
        this.socialCreditCode = socialCreditCode;
        this.storeName = storeName;
        this.number = number;
        this.productClassification = productClassification;
        this.productName = productName;
        this.productSpecification = productSpecification;
        this.productOriginalPrice = productOriginalPrice;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
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

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getProductClassification() {
        return this.productClassification;
    }
    
    public void setProductClassification(String productClassification) {
        this.productClassification = productClassification;
    }

    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpecification() {
        return this.productSpecification;
    }
    
    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public String getProductOriginalPrice() {
        return this.productOriginalPrice;
    }
    
    public void setProductOriginalPrice(String productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public String getDiscountPrice() {
        return this.discountPrice;
    }
    
    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
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
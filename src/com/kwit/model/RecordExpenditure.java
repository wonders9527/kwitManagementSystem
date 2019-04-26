package com.kwit.model;

import java.sql.Timestamp;


public class RecordExpenditure  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "RecordExpenditure [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", expenditureType=" + expenditureType + ", expenditureAmount=" + expenditureAmount
				+ ", expenditureTime=" + expenditureTime + ", expenditureDescription=" + expenditureDescription
				+ ", remark=" + remark + ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

	private Integer id;
     private String socialCreditCode;
     private String storeName;
     private String expenditureType;
     private String expenditureAmount;
     private Timestamp expenditureTime;
     private String expenditureDescription;
     private String remark;
     private Timestamp createDate;
     private String temp1;
     private String temp2;


    // Constructors

    /** default constructor */
    public RecordExpenditure() {
    }

	/** minimal constructor */
    public RecordExpenditure(String socialCreditCode, String storeName, String expenditureType, String expenditureAmount, Timestamp expenditureTime, Timestamp createDate) {
        this.socialCreditCode = socialCreditCode;
        this.storeName = storeName;
        this.expenditureType = expenditureType;
        this.expenditureAmount = expenditureAmount;
        this.expenditureTime = expenditureTime;
        this.createDate = createDate;
    }
    
    /** full constructor */
    public RecordExpenditure(String socialCreditCode, String storeName, String expenditureType, String expenditureAmount, Timestamp expenditureTime, String expenditureDescription, String remark, Timestamp createDate, String temp1, String temp2) {
        this.socialCreditCode = socialCreditCode;
        this.storeName = storeName;
        this.expenditureType = expenditureType;
        this.expenditureAmount = expenditureAmount;
        this.expenditureTime = expenditureTime;
        this.expenditureDescription = expenditureDescription;
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

    public String getExpenditureType() {
        return this.expenditureType;
    }
    
    public void setExpenditureType(String expenditureType) {
        this.expenditureType = expenditureType;
    }

    public String getExpenditureAmount() {
        return this.expenditureAmount;
    }
    
    public void setExpenditureAmount(String expenditureAmount) {
        this.expenditureAmount = expenditureAmount;
    }

    public Timestamp getExpenditureTime() {
        return this.expenditureTime;
    }
    
    public void setExpenditureTime(Timestamp expenditureTime) {
        this.expenditureTime = expenditureTime;
    }

    public String getExpenditureDescription() {
        return this.expenditureDescription;
    }
    
    public void setExpenditureDescription(String expenditureDescription) {
        this.expenditureDescription = expenditureDescription;
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
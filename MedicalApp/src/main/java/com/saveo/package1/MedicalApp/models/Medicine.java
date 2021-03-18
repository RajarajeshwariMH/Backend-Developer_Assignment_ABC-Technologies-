package com.saveo.package1.MedicalApp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "new_table")
public class Medicine {
	
	@Column(name = "c_name")
	private String name;
	
	@Id
	@Column(name = "c_batch_number")
	private String batchNo;
	
	
	@Column(name = "c_expiry_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	
	@Column(name = "n_balance_qty")
	private int balanceQty;
	
	@Column(name = "c_packaging")
	private String packaging;
	
	@Column(name = "c_unique_code")
	private String uniqueCode;
	
	@Column(name = "c_schemes")
	private String schemes;
	
	@Column(name = "n_mrp")
	private double mrp;
	
	@Column(name = "c_manufacturer")
	private String manufacturer;
	
	@Column(name = "hsn_code")
	private String hsnCode;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate date1) {
		this.expiryDate = date1;
	}
	public int getBalanceQty() {
		return balanceQty;
	}
	public void setBalanceQty(int balanceQty) {
		this.balanceQty = balanceQty;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public String getSchemes() {
		return schemes;
	}
	public void setSchemes(String schemes) {
		this.schemes = schemes;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	@Override
	public String toString() {
		return "Medicine [name=" + name + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate + ", balanceQty="
				+ balanceQty + ", packaging=" + packaging + ", uniqueCode=" + uniqueCode + ", schemes=" + schemes
				+ ", mrp=" + mrp + ", manufacturer=" + manufacturer + ", hsnCode=" + hsnCode + "]";
	}

	
}

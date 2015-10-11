package com.altimetrik.texreturn.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


	/**
	 * The persistent class for the taxreturn database table.
	 * 
	 */
	@Entity
	@Table(name= "taxreturn")  
	@NamedQuery(name="Taxreturn.findAll", query="SELECT t FROM Taxreturn t")
	public class Taxreturn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="doc_id")
	private int docId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="doc_type")
	private String docType;
	
	@Lob
	@Column(name="file_data")
	private String fileData;

	@Column(name="financial_year")
	private String financialYear;
	
	@Column(name="file_size")
	private long fileSize;
	
	@Column(name="file_type")
	private String fileType;
	
	@Column(name="file_name")
	private String fileName;
	

	@Column(name="name")
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	public int getDocId() {
	return this.docId;
	}

	public void setDocId(int docId) {
	this.docId = docId;
	}

	public Date getCreatedDate() {
	return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
	}

	public String getDocType() {
	return this.docType;
	}

	public void setDocType(String docType) {
	this.docType = docType;
	}

	public String getFileData() {
	return this.fileData;
	}

	public void setFileData(String fileData) {
	this.fileData = fileData;
	}

	public String getFinancialYear() {
	return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
	this.financialYear = financialYear;
	}

	public String getName() {
	return this.name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public Date getUpdatedDate() {
	return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
	}
	
	
	
   public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

public Taxreturn()
   {
	   super();
   }
   public Taxreturn(int docId,Date createdDate,String docType,String fileData,String financialYear,String name,Date updatedDate,String fileSize,String fileType,String fileName){
	   this.docId = docId;
	   this.createdDate = createdDate;
	   this.docType =  docType;
	   this.fileData = fileData;
	   this.financialYear = financialYear;
	   this.name = name;
	   this.updatedDate = updatedDate;
   }
	}




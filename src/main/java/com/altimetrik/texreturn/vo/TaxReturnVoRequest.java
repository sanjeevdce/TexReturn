package com.altimetrik.texreturn.vo;

public class TaxReturnVoRequest {
	
	private String docType;
	
	private MyFileDoc myFile;

	private String financialYear;

	private String name;

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}


	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyFileDoc getMyFile() {
		return myFile;
	}

	public void setMyFile(MyFileDoc myFile) {
		this.myFile = myFile;
	}

	
	

}

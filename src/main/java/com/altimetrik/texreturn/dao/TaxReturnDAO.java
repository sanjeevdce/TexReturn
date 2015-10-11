package com.altimetrik.texreturn.dao;

import java.util.List;

import com.altimetrik.texreturn.domain.Taxreturn;

public interface TaxReturnDAO {
	
	public void saveEmployee(Taxreturn taxretyrb);
	public List<Taxreturn>  getTaxReturnDtls(String  name, String docType, String financialYear);
	public List<Taxreturn>  getDisplayList();
	
	
	public List<String>  getNameList();
		
	public List<String>  getDocTypeList();
		
	public List<String>  getFinYearList();
	
}

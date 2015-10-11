package com.altimetrik.texreturn.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.altimetrik.texreturn.domain.Taxreturn;
import com.altimetrik.texreturn.vo.TaxReturnListResponse;
import com.altimetrik.texreturn.vo.TaxReturnVoRequest;
import com.altimetrik.texreturn.vo.TaxReturnsResponse;
import com.altimetrik.texreturn.vo.SearchTaxReturnsResponse;

public class DomainToVOTransformer {

	public static TaxReturnListResponse convertDisplayDoToVo(
			List<Taxreturn> raxreturnList) {
		List<TaxReturnsResponse> taxReturnsResponseList = new ArrayList<TaxReturnsResponse>();
		TaxReturnsResponse taxReturnsResponse = new TaxReturnsResponse();
		TaxReturnListResponse taxReturnListResponse = new TaxReturnListResponse();

		for (Taxreturn taxreturn : raxreturnList) {
			taxReturnsResponse.setDocType(taxreturn.getDocType());
			taxReturnsResponse.setName(taxreturn.getName());
			taxReturnsResponse.setFinancialYear(taxreturn.getFinancialYear());
			taxReturnsResponseList.add(taxReturnsResponse);
		}
		taxReturnListResponse.setTaxReturnsResponseList(taxReturnsResponseList);
		return taxReturnListResponse;
	}

	public static SearchTaxReturnsResponse convertTaxRetunDoToVo(
			List<Taxreturn> taxReturnList) {
		Taxreturn taxreturn = null;
		SearchTaxReturnsResponse texReturnVo = new SearchTaxReturnsResponse();
		if(!taxReturnList.isEmpty()){
			taxreturn  = taxReturnList.get(0);
		texReturnVo.setName(taxreturn.getName());
		texReturnVo.setDocType(taxreturn.getDocType());
		texReturnVo.setFinancialYear(taxreturn.getFinancialYear());
		texReturnVo.setCreatedDate(taxreturn.getCreatedDate());
		texReturnVo.setUpdatedDate(taxreturn.getUpdatedDate());
		texReturnVo.setFileData(taxreturn.getFileData());
		}
		return texReturnVo;
	}

	public static Taxreturn convertTaxRetunVoToDo(
			TaxReturnVoRequest taxReturnVoRequest) {

		Taxreturn taxreturn = new Taxreturn();
		taxreturn.setName(taxReturnVoRequest.getName());
		taxreturn.setDocType(taxReturnVoRequest.getDocType());
		taxreturn.setFinancialYear(taxReturnVoRequest.getFinancialYear());
		taxreturn.setCreatedDate(new Date());
		taxreturn.setUpdatedDate(new Date());
		taxreturn.setFileData(taxReturnVoRequest.getMyFile().getBase64());
		taxreturn.setFileName(taxReturnVoRequest.getMyFile().getFilename());

		taxreturn.setFileSize(Long.parseLong(taxReturnVoRequest.getMyFile()
				.getFilesize()));
		taxreturn.setFileType(taxReturnVoRequest.getMyFile().getFiletype());
		return taxreturn;
	}
}

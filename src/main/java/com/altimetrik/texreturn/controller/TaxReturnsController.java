package com.altimetrik.texreturn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.altimetrik.texreturn.businessobject.Status;
import com.altimetrik.texreturn.businessobject.TaxReturnResponse;
import com.altimetrik.texreturn.constants.TaxReturnsURIConstants;
import com.altimetrik.texreturn.dao.TaxReturnDAO;
import com.altimetrik.texreturn.domain.Taxreturn;
import com.altimetrik.texreturn.util.DomainToVOTransformer;
import com.altimetrik.texreturn.vo.SearchTaxReturnsRequest;
import com.altimetrik.texreturn.vo.SearchTaxReturnsResponse;
import com.altimetrik.texreturn.vo.TaxReturnListResponse;
import com.altimetrik.texreturn.vo.TaxReturnListVo;
import com.altimetrik.texreturn.vo.TaxReturnVoRequest;


@Controller
public class TaxReturnsController {

	@Autowired
	private TaxReturnDAO employeedao;
	private static final Logger logger = LoggerFactory
			.getLogger(TaxReturnsController.class);

	@RequestMapping(value = TaxReturnsURIConstants.GET_TAX_RETURNS_DTLS, method = RequestMethod.POST)
	public @ResponseBody
	SearchTaxReturnsResponse getTaxReturnDtls(
			@RequestBody SearchTaxReturnsRequest searchTaxReturnsRequest) {
		logger.info("Started getTaxReturnDtls.");
		// List<Taxreturn> taxReturnList =
		// employeedao.getTaxReturnDtls("hellotestuser2", "Form16", "2014");
		List<Taxreturn> taxReturnList = employeedao.getTaxReturnDtls(
				searchTaxReturnsRequest.getName(),
				searchTaxReturnsRequest.getDocType(),
				searchTaxReturnsRequest.getFinancialYear());
		SearchTaxReturnsResponse searchTaxReturnsResponse = DomainToVOTransformer
				.convertTaxRetunDoToVo(taxReturnList);
		return searchTaxReturnsResponse;
	}

	@RequestMapping(value = TaxReturnsURIConstants.GET_DISPLAY_LIST_UNQ, method = RequestMethod.GET)
	public @ResponseBody
	TaxReturnListVo getDisplayListUnique() {
		logger.info("Started getDisplayList.");
		List<String> nameList = employeedao.getNameList();
		List<String> docTypeList = employeedao.getDocTypeList();
		List<String> finYearList = employeedao.getFinYearList();
		TaxReturnListVo taxReturnListVo = new TaxReturnListVo();
		taxReturnListVo.setNameList(nameList);
		taxReturnListVo.setDoctypeList(docTypeList);
		taxReturnListVo.setFinYearList(finYearList);
		return taxReturnListVo;

	}

	@RequestMapping(value = TaxReturnsURIConstants.GET_DISPLAY_LIST, method = RequestMethod.GET)
	public @ResponseBody
	TaxReturnListResponse getDisplayList() {
		logger.info("Started getDisplayList.");
		List<Taxreturn> taxReturnList = employeedao.getDisplayList();
		TaxReturnListResponse taxReturnListResponse = DomainToVOTransformer
				.convertDisplayDoToVo(taxReturnList);
		return taxReturnListResponse;

	}

	/*
	 * @RequestMapping(value = TaxReturnsURIConstants.SAVE_TAX_RETURNS_DTLS,
	 * method = RequestMethod.POST) public @ResponseBody String
	 * saveTaxReturnDtls(@PathVariable("docType") String
	 * docType,@PathVariable("fileData") String
	 * fileData,@PathVariable("financialYear") String
	 * financialYear,@PathVariable("name") String name) { /*
	 * taxreturn.setCreatedDate(new Date()); taxreturn.setName(name);
	 * taxreturn.setDocType(docType); taxreturn.setFileData(fileData);
	 * taxreturn.setFinancialYear(financialYear); taxreturn.setUpdatedDate(new
	 * Date())
	 */

	/*
	 * @RequestMapping(value = TaxReturnsURIConstants.SAVE_TAX_RETURNS_DTLS,
	 * method = RequestMethod.POST) public @ResponseBody TaxReturnResponse
	 * saveTaxReturnDtls(@RequestBody TaxReturnVoRequest taxReturnVoRequest) {
	 * logger.info("Started getDisplayList."); Taxreturn taxreturn =
	 * DomainToVOTransformer.convertTaxRetunVoToDo(taxReturnVoRequest); //
	 * employeedao.saveEmployee(taxreturn); Taxreturn taxreturn = new
	 * Taxreturn(); taxreturn.setCreatedDate(new Date());
	 * taxreturn.setName("testname"); taxreturn.setDocType("Form16");
	 * taxreturn.setFileData("asdfnasdfasdf");
	 * taxreturn.setFinancialYear("2014"); taxreturn.setUpdatedDate(new Date());
	 * employeedao.saveEmployee(taxreturn); TaxReturnResponse taxReturnResponse
	 * = new TaxReturnResponse(); Status status = new Status();
	 * status.setStatus("saved Successfully");
	 * taxReturnResponse.setStatus(status); return taxReturnResponse; }
	 */

	@RequestMapping(value = TaxReturnsURIConstants.SAVE_TAX_RETURNS_DTLS, method = RequestMethod.POST)
	public @ResponseBody
	TaxReturnResponse saveTaxReturnDtls(
			@RequestBody TaxReturnVoRequest taxReturnVoRequest) {
		logger.info("Started getDisplayList.");
		Taxreturn taxreturn = DomainToVOTransformer
				.convertTaxRetunVoToDo(taxReturnVoRequest);
		// employeedao.saveEmployee(taxreturn);
		/*
		 * Taxreturn taxreturn = new Taxreturn(); taxreturn.setCreatedDate(new
		 * Date()); taxreturn.setName("testname");
		 * taxreturn.setDocType("Form16");
		 * taxreturn.setFileData("asdfnasdfasdf");
		 * taxreturn.setFinancialYear("2014"); taxreturn.setUpdatedDate(new
		 * Date());
		 */
		employeedao.saveEmployee(taxreturn);
		TaxReturnResponse taxReturnResponse = new TaxReturnResponse();
		Status status = new Status();
		status.setStatus("saved Successfully");
		taxReturnResponse.setStatus(status);
		return taxReturnResponse;
	}
}

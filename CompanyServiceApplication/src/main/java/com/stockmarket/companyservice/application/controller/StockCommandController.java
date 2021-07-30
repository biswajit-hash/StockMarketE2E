package com.stockmarket.companyservice.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.companyservice.application.dto.CompanyLookupReponse;
import com.stockmarket.companyservice.application.dto.StockPriceDto;
import com.stockmarket.companyservice.application.exception.CompanyNotFoundException;
import com.stockmarket.companyservice.application.service.CompanyQueryService;
import com.stockmarket.companyservice.application.service.StockCommandService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/api/v1.0/market")
public class StockCommandController {
	
	@Autowired
	private StockCommandService stockCommandService;
	
	@Autowired
	private CompanyQueryService companyQueryService;
	
	@PostMapping(path = "stock/add/{companyCode}")
	public ResponseEntity<?> addStockPriceToCompany(@PathVariable String companyCode, @RequestBody StockPriceDto stockPriceDto) 
			throws CompanyNotFoundException
	{
		CompanyLookupReponse companyLookupReponse = companyQueryService.findByCode(companyCode);
		if(companyLookupReponse == null) {
			throw new CompanyNotFoundException("Company not with code : " + companyCode);
		}
		stockPriceDto.setAddedDate(java.time.LocalDate.now());
		stockPriceDto.setTime(java.time.LocalTime.now());
		stockPriceDto.setCompanyCode(companyCode);
		return ResponseEntity.ok(stockCommandService.addStock(stockPriceDto));
	}
	
}

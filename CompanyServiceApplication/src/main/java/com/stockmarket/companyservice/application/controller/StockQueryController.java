package com.stockmarket.companyservice.application.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.companyservice.application.dto.StockLookupReponse;
import com.stockmarket.companyservice.application.exception.CompanyNotFoundException;
import com.stockmarket.companyservice.application.service.StockQueryService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/api/v1.0/market")
public class StockQueryController {
	
	@Autowired
	private StockQueryService stockQueryService;
	
	@GetMapping(path = "stock/get/{comapnyCode}/{startDate}/{endDate}")
	public ResponseEntity<?> getStockPrices(@PathVariable String comapnyCode,
			@PathVariable String startDate,@PathVariable String endDate)
			throws CompanyNotFoundException
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		LocalDate from = LocalDate.parse(startDate,formatter);
		LocalDate to = LocalDate.parse(endDate,formatter);
		StockLookupReponse stockLookupReponse = stockQueryService.getStockByCodeAndDate(comapnyCode,from,to);
		if(stockLookupReponse == null) {
			throw new CompanyNotFoundException("Company not found at id : " + comapnyCode);
		}
		return ResponseEntity.ok(stockLookupReponse);
	}


}

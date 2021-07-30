package com.stockmarket.companyservice.application.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stockmarket.companyservice.application.dto.CompanyDto;
import com.stockmarket.companyservice.application.dto.CompanyLookupReponse;
import com.stockmarket.companyservice.application.exception.CompanyExistsException;
import com.stockmarket.companyservice.application.exception.CompanyNotFoundException;
import com.stockmarket.companyservice.application.service.CompanyCommandService;
import com.stockmarket.companyservice.application.service.CompanyQueryService;
import com.stockmarket.companyservice.application.service.StockCommandService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/api/v1.0/market")
public class CompanyCommandController 
{
	@Autowired
	private CompanyCommandService commandService;
	
	@Autowired
	private CompanyQueryService companyQueryService;
	
	@Autowired
	private StockCommandService stockCommandService;
	
	
	@PostMapping(path = "/company/register")
	@HystrixCommand(fallbackMethod = "defaultResponse")
	public ResponseEntity<?> addCompany(@Valid@RequestBody CompanyDto companyDto) throws CompanyExistsException {
		
		  CompanyLookupReponse companyLookupReponse =
		  companyQueryService.findByCode(companyDto.getCode()); if(companyLookupReponse
		  != null) { throw new CompanyExistsException("Company already exists : " +
		  companyDto.getCode()); }
		 
		return ResponseEntity.ok(commandService.registerCompany(companyDto));
	}
	
	
	@DeleteMapping(path = "delete/{companyCode}")
	public void deleteCompany(@PathVariable String companyCode) throws CompanyNotFoundException {
		CompanyLookupReponse companyLookupReponse = companyQueryService.findByCode(companyCode);
		if(companyLookupReponse == null) {
			throw new CompanyNotFoundException("Company not with code : " + companyCode);
		}
		commandService.removeCompany(UUID.randomUUID().toString(),companyLookupReponse.getCompanyDtos().get(0).getId());
		stockCommandService.removeStock(UUID.randomUUID().toString(),companyCode);
	}
	
	/* Feign Client Default Response */
	
	public ResponseEntity<?> defaultResponse(@RequestBody CompanyDto companyDto) {
		String err = "Fallback error as the microservice is down.";
		return ResponseEntity
				.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body(err);
	}
}

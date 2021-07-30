package com.stockmarket.companyservice.application.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyLookupReponse extends BaseResponse{
	
	private List<CompanyDto> companyDtos;

	public CompanyLookupReponse(String message) {
		super(message);
	}

	 public CompanyLookupReponse(List<CompanyDto> companyDtos) {
	        super(null);
	        this.companyDtos = companyDtos;
	 }
	 
	 public CompanyLookupReponse(String message, CompanyDto companyDto) {
	        super(message);
	        this.companyDtos = new ArrayList<>();
	        this.companyDtos.add(companyDto);
	 }
	 
	 public CompanyLookupReponse(CompanyDto companyDto) {
	        super(null);
	        this.companyDtos = new ArrayList<>();
	        this.companyDtos.add(companyDto);
    }

    public List<CompanyDto> getCompanyDtos() {
        return this.companyDtos;
    }

    public void setCompanyDtos(List<CompanyDto> companyDto) {
        this.companyDtos = companyDto;
    }

}

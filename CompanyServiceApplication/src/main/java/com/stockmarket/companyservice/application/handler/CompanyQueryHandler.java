package com.stockmarket.companyservice.application.handler;

import com.stockmarket.companyservice.application.dto.CompanyLookupReponse;
import com.stockmarket.companyservice.application.query.FindAllCompanyQuery;
import com.stockmarket.companyservice.application.query.FindCompanyByCodeQuery;

public interface CompanyQueryHandler {
	
	CompanyLookupReponse getCompanyByCode(FindCompanyByCodeQuery query);
	CompanyLookupReponse getAllCompanies(FindAllCompanyQuery query);

}
package com.stockmarket.companyservice.application.service;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import com.stockmarket.companyservice.application.dto.CompanyLookupReponse;
import com.stockmarket.companyservice.application.query.FindAllCompanyQuery;
import com.stockmarket.companyservice.application.query.FindCompanyByCodeQuery;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyQueryService {
	
	private final QueryGateway queryGateway;
	
	 public CompanyLookupReponse findAll() {
	        return this.queryGateway.query(
	                new FindAllCompanyQuery(),
	                ResponseTypes.instanceOf(CompanyLookupReponse.class)
	        ).join();
	}

    public CompanyLookupReponse findByCode(String code) {
        return this.queryGateway.query(
                new FindCompanyByCodeQuery(code),
                ResponseTypes.instanceOf(CompanyLookupReponse.class)
        ).join();
    }

}

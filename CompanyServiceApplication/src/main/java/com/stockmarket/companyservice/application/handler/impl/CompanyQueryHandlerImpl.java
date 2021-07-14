package com.stockmarket.companyservice.application.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.stockmarket.companyservice.application.dto.CompanyLookupReponse;
import com.stockmarket.companyservice.application.handler.CompanyQueryHandler;
import com.stockmarket.companyservice.application.mapper.CompanyMapper;
import com.stockmarket.companyservice.application.model.Company;
import com.stockmarket.companyservice.application.query.FindAllCompanyQuery;
import com.stockmarket.companyservice.application.query.FindCompanyByCodeQuery;
import com.stockmarket.companyservice.application.repository.CompanyRepository;

@Service
public class CompanyQueryHandlerImpl implements CompanyQueryHandler{

	private final CompanyRepository companyRepository;
	
	 @Autowired
	 private CompanyMapper companyMapper;

    @Autowired
    public CompanyQueryHandlerImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @QueryHandler
    @Override
    public CompanyLookupReponse getCompanyByCode(FindCompanyByCodeQuery query) {
        Optional<Company> company = companyRepository.findByCode(query.getCode());
        return company.isPresent() ? new CompanyLookupReponse(companyMapper.toCompanyDto(company.get())) : null;
    }
    
    @QueryHandler
	@Override
	public CompanyLookupReponse getAllCompanies(FindAllCompanyQuery query) {
		List<Company> companies = new ArrayList<>(companyRepository.findAll());
	    return new CompanyLookupReponse(companyMapper.toCompanyDtos(companies));
	}
}

package com.stockmarket.companyservice.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.google.common.base.Optional;
import com.stockmarket.companyservice.application.model.Company;

public interface CompanyRepository extends MongoRepository<Company, String>{
	Optional<Company> findByCode(String code);
}
package com.stockmarket.companyservice.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stockmarket.companyservice.application.model.StockPrice;

public interface StockRepository extends MongoRepository<StockPrice, String>{
	
	public void deleteByCompanyCode(String companyCode);
	public List<StockPrice> findByCompanyCode(String code);

}

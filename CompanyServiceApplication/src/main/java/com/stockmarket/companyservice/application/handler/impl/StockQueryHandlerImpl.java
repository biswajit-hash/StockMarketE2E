package com.stockmarket.companyservice.application.handler.impl;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.stockmarket.companyservice.application.dto.StockLookupReponse;
import com.stockmarket.companyservice.application.handler.StockQueryHandler;
import com.stockmarket.companyservice.application.mapper.StockPriceMapper;
import com.stockmarket.companyservice.application.model.StockPrice;
import com.stockmarket.companyservice.application.query.FindStockByCodeAndDateQuery;
import com.stockmarket.companyservice.application.query.FindStockByCompanyCodeQuery;
import com.stockmarket.companyservice.application.repository.StockRepository;

@Service
public class StockQueryHandlerImpl implements StockQueryHandler{
	
	private final StockRepository stockRepository;
	
	 @Autowired
	 private StockPriceMapper stockPriceMapper;
	 
	 @Autowired
	 MongoOperations mongoOperations;
	 
	 @Autowired
    public StockQueryHandlerImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
	 
	@QueryHandler
	@Override
	public StockLookupReponse getStockByCodeAndDate(FindStockByCodeAndDateQuery query) {
		Query criteriaQuery = new Query();
		criteriaQuery = criteriaQuery.addCriteria(Criteria.where("addedDate").gte(query.getStartDate().atStartOfDay()).lte(query.getEndDate().atStartOfDay())
		                          .and("companyCode").is(query.getCode()));
		List<StockPrice> stockPriceDtos = mongoOperations.find(criteriaQuery, StockPrice.class);
		return new StockLookupReponse(stockPriceMapper.toStockPriceDtos(stockPriceDtos));
	}
	
	@QueryHandler
    @Override
    public StockLookupReponse getStockByCompanyCode(FindStockByCompanyCodeQuery query) {
        List<StockPrice> stock = stockRepository.findByCompanyCode(query.getCode());
        return new StockLookupReponse(stockPriceMapper.toStockPriceDtos(stock));
    }
	    

}

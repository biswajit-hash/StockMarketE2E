package com.stockmarket.companyservice.application.service;

import java.time.LocalDate;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import com.stockmarket.companyservice.application.dto.StockLookupReponse;
import com.stockmarket.companyservice.application.query.FindStockByCodeAndDateQuery;
import com.stockmarket.companyservice.application.query.FindStockByCompanyCodeQuery;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockQueryService {
	
	private final QueryGateway queryGateway;

    public StockLookupReponse getStockByCodeAndDate(String code,LocalDate from,LocalDate to) {
        return this.queryGateway.query(
                new FindStockByCodeAndDateQuery(code,from,to),
                ResponseTypes.instanceOf(StockLookupReponse.class)
        ).join();
    }

    public StockLookupReponse getStockByCompanyCode(String code) {
        return this.queryGateway.query(
                new FindStockByCompanyCodeQuery(code),
                ResponseTypes.instanceOf(StockLookupReponse.class)
        ).join();
    }

}

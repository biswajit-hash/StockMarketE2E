package com.stockmarket.companyservice.application.handler;

import com.stockmarket.companyservice.application.dto.StockLookupReponse;
import com.stockmarket.companyservice.application.query.FindStockByCodeAndDateQuery;
import com.stockmarket.companyservice.application.query.FindStockByCompanyCodeQuery;

public interface StockQueryHandler {
	
	StockLookupReponse getStockByCodeAndDate(FindStockByCodeAndDateQuery query);
	StockLookupReponse getStockByCompanyCode(FindStockByCompanyCodeQuery query);
}
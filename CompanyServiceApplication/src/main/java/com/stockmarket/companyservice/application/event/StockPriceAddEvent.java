package com.stockmarket.companyservice.application.event;

import com.stockmarket.companyservice.application.model.StockPrice;

import lombok.Data;

@Data
public class StockPriceAddEvent {
	
	private final String id;
	private final StockPrice stockPrice;

}
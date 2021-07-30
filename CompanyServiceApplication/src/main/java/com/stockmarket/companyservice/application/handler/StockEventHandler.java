package com.stockmarket.companyservice.application.handler;

import com.stockmarket.companyservice.application.event.StockPriceAddEvent;
import com.stockmarket.companyservice.application.event.StockPriceRemovedEvent;

public interface StockEventHandler {
	void on(StockPriceAddEvent event);
	void on(StockPriceRemovedEvent event);
}
package com.stockmarket.companyservice.application.handler.impl;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.companyservice.application.event.StockPriceAddEvent;
import com.stockmarket.companyservice.application.event.StockPriceRemovedEvent;
import com.stockmarket.companyservice.application.handler.StockEventHandler;
import com.stockmarket.companyservice.application.repository.StockRepository;

@Service
@ProcessingGroup("stock-group")
public class StockHandlerImpl implements StockEventHandler{

	private final StockRepository stockRepository;

    @Autowired
    public StockHandlerImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @EventHandler
	@Override
	public void on(StockPriceAddEvent event) {
		stockRepository.save(event.getStockPrice());
		
	}
    
    @EventHandler
	@Override
	public void on(StockPriceRemovedEvent event) {
		stockRepository.deleteByCompanyCode(event.getCompanyCode());
		
	}

}

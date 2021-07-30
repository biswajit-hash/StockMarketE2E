package com.stockmarket.companyservice.application.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.companyservice.application.command.RemoveStockPriceCommand;
import com.stockmarket.companyservice.application.command.StockPriceCommand;
import com.stockmarket.companyservice.application.dto.CompanyDto;
import com.stockmarket.companyservice.application.dto.StockLookupReponse;
import com.stockmarket.companyservice.application.dto.StockPriceDto;
import com.stockmarket.companyservice.application.mapper.StockPriceMapper;
import com.stockmarket.companyservice.application.model.StockPrice;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockCommandService {
	
	private final CommandGateway  commandGateway;
	 
	 @Autowired
	 private StockPriceMapper stockPriceMapper;
	 
	 @Autowired
	 private StockQueryService stockQueryService;
		
	
	  public CompletableFuture<CompanyDto> addStock(StockPriceDto stockPriceDto) {
		  stockPriceDto.setId(UUID.randomUUID().toString());
	        return this.commandGateway.send(new StockPriceCommand(
	        		stockPriceDto.getId(),
	                stockPriceMapper.toStockPrice(stockPriceDto)
	        ));
	    }
	  
	  public CompletableFuture<StockPrice> removeStock(String id, String companyCode) {
	        return this.commandGateway.send(new RemoveStockPriceCommand(
	               id,
	               companyCode
	        ));
	    }
}

package com.stockmarket.companyservice.application.dto;

import java.util.ArrayList;
import java.util.List;

public class StockLookupReponse extends BaseResponse{
	
	private List<StockPriceDto> stockPriceDtos;

	public StockLookupReponse(String message) {
		super(message);
	}

	 public StockLookupReponse(List<StockPriceDto> stockPriceDtos) {
	        super(null);
	        this.stockPriceDtos = stockPriceDtos;
	 }
	 
	 public StockLookupReponse(String message, StockPriceDto stockPriceDto) {
	        super(message);
	        this.stockPriceDtos = new ArrayList<>();
	        this.stockPriceDtos.add(stockPriceDto);
	 }
	 
	 public StockLookupReponse(StockPriceDto stockPriceDto) {
	        super(null);
	        this.stockPriceDtos = new ArrayList<>();
	        this.stockPriceDtos.add(stockPriceDto);
    }

    public List<StockPriceDto> getStockDtos() {
        return this.stockPriceDtos;
    }

    public void setUsers(List<StockPriceDto> stockPriceDto) {
        this.stockPriceDtos = stockPriceDto;
    }

}

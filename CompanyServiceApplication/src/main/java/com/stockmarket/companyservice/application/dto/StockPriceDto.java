package com.stockmarket.companyservice.application.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto 
{
	private String id;
	private String companyCode;
	private String stockExchangeName;
	private double price;
	private LocalDate addedDate;
	private LocalTime time;

}
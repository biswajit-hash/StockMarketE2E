package com.stockmarket.companyservice.application.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "stock")
public class StockPrice 
{
	@Id
	private String id;
	private String companyCode;
	private String stockExchangeName;
	private double price;
	private LocalDate addedDate;
	private LocalTime time;
}

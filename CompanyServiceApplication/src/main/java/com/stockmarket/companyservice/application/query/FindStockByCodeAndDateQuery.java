package com.stockmarket.companyservice.application.query;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindStockByCodeAndDateQuery {
	private String code;
	private LocalDate startDate;
	private LocalDate endDate;
}
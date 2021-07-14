package com.stockmarket.companyservice.application.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindCompanyByCodeQuery {
	private String code;
}
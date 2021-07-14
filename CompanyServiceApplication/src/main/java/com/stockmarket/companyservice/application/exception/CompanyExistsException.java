package com.stockmarket.companyservice.application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyExistsException extends Throwable
{
	private String message;
}

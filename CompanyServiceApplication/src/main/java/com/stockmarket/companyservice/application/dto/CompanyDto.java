package com.stockmarket.companyservice.application.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto 
{
	private String id;
	@NotNull(message = "Comapny name is mandatory")
	@NotEmpty(message = "Comapny name is mandatory")
	private String name;
	@NotNull(message = "Comapny Code is mandatory")
	@NotEmpty(message = "Comapny Code is mandatory")
	private String code;
	@NotNull(message = "Comapny turnover is mandatory")
	@NotEmpty(message = "Comapny turnover is mandatory")
    @Min(value=10000000,message="Company turnover should be greater than 10cr")
	private String turnover;
	@NotNull(message = "Comapny CEO is mandatory")
	@NotEmpty(message = "Comapny CEO is mandatory")
	private String ceo;
	@NotNull(message = "Stock Exchange name is mandatory")
	@NotEmpty(message = "Stock Exchange name is mandatory")
	private String stockExchangeNames;
	@NotNull(message = "Comapny website is mandatory")
	@NotEmpty(message = "Comapny website is mandatory")
	private String companyWebsite;
}

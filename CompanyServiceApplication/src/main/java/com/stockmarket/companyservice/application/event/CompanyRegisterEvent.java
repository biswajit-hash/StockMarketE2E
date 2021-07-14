package com.stockmarket.companyservice.application.event;

import com.stockmarket.companyservice.application.model.Company;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyRegisterEvent {
	private final String id;
	private final Company company;
}

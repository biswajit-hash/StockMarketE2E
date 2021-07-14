package com.stockmarket.companyservice.application.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.stockmarket.companyservice.application.model.Company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCompanyCommand {
	
	@TargetAggregateIdentifier
	private String id;
	@NotNull(message = "no company details were supplied")
    @Valid
	private Company company;
}

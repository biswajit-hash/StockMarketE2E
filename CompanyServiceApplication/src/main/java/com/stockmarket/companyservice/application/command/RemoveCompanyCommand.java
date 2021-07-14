package com.stockmarket.companyservice.application.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveCompanyCommand {
	@TargetAggregateIdentifier
    private String id;
	private String companyId;
}

package com.stockmarket.companyservice.application.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveStockPriceCommand {
	@TargetAggregateIdentifier
    private String id;
	private String companyCode;
}

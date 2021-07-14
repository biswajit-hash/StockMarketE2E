package com.stockmarket.companyservice.application.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.stockmarket.companyservice.application.model.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceCommand {
	
	@TargetAggregateIdentifier
	private String id;
	@NotNull(message = "no company details were supplied")
    @Valid
	private StockPrice stockPrice;

}

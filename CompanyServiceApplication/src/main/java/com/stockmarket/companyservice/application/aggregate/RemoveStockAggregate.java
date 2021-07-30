package com.stockmarket.companyservice.application.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.stockmarket.companyservice.application.command.RemoveStockPriceCommand;
import com.stockmarket.companyservice.application.event.StockPriceRemovedEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class RemoveStockAggregate {
	@AggregateIdentifier
	private String id;
	private String companyCode;
	
	  @CommandHandler
	  public RemoveStockAggregate(RemoveStockPriceCommand command) {
		  StockPriceRemovedEvent event = StockPriceRemovedEvent.builder()
				  .id(command.getId())
				  .companyCode(command.getCompanyCode())
				  .build();
		  AggregateLifecycle.apply(event);
	  
	  }
	 
    @EventSourcingHandler
    public void on(StockPriceRemovedEvent event) {
    	this.id = event.getId();
    	this.companyCode = event.getCompanyCode();
    	AggregateLifecycle.markDeleted();
    }
}

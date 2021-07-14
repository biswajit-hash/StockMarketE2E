package com.stockmarket.companyservice.application.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.stockmarket.companyservice.application.command.StockPriceCommand;
import com.stockmarket.companyservice.application.event.StockPriceAddEvent;
import com.stockmarket.companyservice.application.model.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class StockAggregate {

	@AggregateIdentifier
	private String id;
	private StockPrice stockPrice;
	
	@CommandHandler
    public StockAggregate(StockPriceCommand command) {

        AggregateLifecycle.apply(
                new StockPriceAddEvent(
                		command.getId(),
                		 command.getStockPrice()
                )
        );
    }
	 
	@EventSourcingHandler
    public void on(StockPriceAddEvent event) {
        this.id = event.getId();
        this.stockPrice = event.getStockPrice();
    }
	
}

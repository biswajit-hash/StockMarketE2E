package com.stockmarket.companyservice.application.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.stockmarket.companyservice.application.command.RemoveCompanyCommand;
import com.stockmarket.companyservice.application.event.CompanyRemovedEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class RemoveCompanyAggregate {
	@AggregateIdentifier
	private String id;
	private String companyId;
	
	  @CommandHandler
	  public RemoveCompanyAggregate(RemoveCompanyCommand command) {
		  CompanyRemovedEvent event = CompanyRemovedEvent.builder()
				  .id(command.getId())
				  .companyId(command.getCompanyId())
				  .build();
		  AggregateLifecycle.apply(event);
	  
	  }
	 
    @EventSourcingHandler
    public void on(CompanyRemovedEvent event) {
    	this.id = event.getId();
    	this.companyId = event.getCompanyId();
    	AggregateLifecycle.markDeleted();
    }

}

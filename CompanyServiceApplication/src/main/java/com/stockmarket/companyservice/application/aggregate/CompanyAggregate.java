package com.stockmarket.companyservice.application.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.stockmarket.companyservice.application.command.RegisterCompanyCommand;
import com.stockmarket.companyservice.application.event.CompanyRegisterEvent;
import com.stockmarket.companyservice.application.model.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class CompanyAggregate {
	@AggregateIdentifier
	private String id;
	private Company company;
	
	@CommandHandler
    public CompanyAggregate(RegisterCompanyCommand command) {
		Company company = command.getCompany();
		CompanyRegisterEvent event = CompanyRegisterEvent.builder()
				.id(command.getId())
				.company(company)
				.build();
        AggregateLifecycle.apply(event);
    }
	 
	@EventSourcingHandler
    public void on(CompanyRegisterEvent event) {
        this.id = event.getId();
        this.company = event.getCompany();
    }
	
}

package com.stockmarket.companyservice.application.handler.impl;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.companyservice.application.event.CompanyRegisterEvent;
import com.stockmarket.companyservice.application.event.CompanyRemovedEvent;
import com.stockmarket.companyservice.application.handler.CompanyEventHandler;
import com.stockmarket.companyservice.application.repository.CompanyRepository;

@Service
@ProcessingGroup("company-group")
public class ComanyEventHandlerImpl implements CompanyEventHandler{
	
	private final CompanyRepository companyRepository;

    @Autowired
    public ComanyEventHandlerImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @EventHandler
	@Override
	public void on(CompanyRegisterEvent event) {
		companyRepository.save(event.getCompany());
		
	}

    @EventHandler
	@Override
	public void on(CompanyRemovedEvent event) {
		companyRepository.deleteById(event.getCompanyId());
		
	}

}


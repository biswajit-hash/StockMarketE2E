package com.stockmarket.companyservice.application.handler;

import com.stockmarket.companyservice.application.event.CompanyRegisterEvent;
import com.stockmarket.companyservice.application.event.CompanyRemovedEvent;

public interface CompanyEventHandler {
	void on(CompanyRegisterEvent event);
	void on(CompanyRemovedEvent event);
}
package com.stockmarket.companyservice.application.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyRemovedEvent {
	private final String id;
	private final String companyId;
}

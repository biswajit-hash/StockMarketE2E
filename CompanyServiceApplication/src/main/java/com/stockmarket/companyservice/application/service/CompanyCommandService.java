package com.stockmarket.companyservice.application.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.companyservice.application.command.RegisterCompanyCommand;
import com.stockmarket.companyservice.application.command.RemoveCompanyCommand;
import com.stockmarket.companyservice.application.dto.CompanyDto;
import com.stockmarket.companyservice.application.mapper.CompanyMapper;
import com.stockmarket.companyservice.application.model.Company;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyCommandService {
	
	 private final CommandGateway  commandGateway;
	 
	 @Autowired
	 private CompanyMapper companyMapper;
		
	
	  public CompletableFuture<Company> registerCompany(CompanyDto companyDto) {
		  companyDto.setId(UUID.randomUUID().toString());
	        return this.commandGateway.send(new RegisterCompanyCommand(
	        		companyDto.getId().toString(),
	                companyMapper.toCompany(companyDto)
	        ));
	    }
	  
	  public CompletableFuture<Company> removeCompany(String id,String companyId) {
	        return this.commandGateway.send(new RemoveCompanyCommand(
	               id,
	               companyId
	        ));
	    }

}


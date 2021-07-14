package com.stockmarket.Stockmarket2FAuthentication.dto;

import lombok.Value;

@Value
public class ApiResponse {
	private Boolean success;
	private String message;
}
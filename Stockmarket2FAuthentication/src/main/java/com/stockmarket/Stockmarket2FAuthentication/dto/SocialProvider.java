package com.stockmarket.Stockmarket2FAuthentication.dto;

/**
 * @author Biswajit
 * @since 29/06/21
 */
public enum SocialProvider {

	GOOGLE("google"), LOCAL("local");

	private String providerType;

	public String getProviderType() {
		return providerType;
	}

	SocialProvider(final String providerType) {
		this.providerType = providerType;
	}

}

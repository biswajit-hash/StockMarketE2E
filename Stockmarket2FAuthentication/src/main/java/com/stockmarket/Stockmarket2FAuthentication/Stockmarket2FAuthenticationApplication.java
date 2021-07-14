package com.stockmarket.Stockmarket2FAuthentication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.stockmarket")
@EnableJpaRepositories
@EnableTransactionManagement
public class Stockmarket2FAuthenticationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplicationBuilder app = new SpringApplicationBuilder(Stockmarket2FAuthenticationApplication.class);
		app.run();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Stockmarket2FAuthenticationApplication.class);
	}

}

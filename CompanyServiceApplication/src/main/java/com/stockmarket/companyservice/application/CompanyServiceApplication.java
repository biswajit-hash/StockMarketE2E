package com.stockmarket.companyservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.stockmarket.companyservice.application.config.AxonConfig;

/*@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient*/
/*@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})*/
@Import({ AxonConfig.class })
@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}

}
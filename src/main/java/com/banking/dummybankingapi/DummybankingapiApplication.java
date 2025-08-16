package com.banking.dummybankingapi;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DummybankingapiApplication {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper
				.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT);

		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(DummybankingapiApplication.class, args);
	}

}

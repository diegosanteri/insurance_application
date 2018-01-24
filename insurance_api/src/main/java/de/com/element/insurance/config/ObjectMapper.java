package de.com.element.insurance.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author diegosanteri
 *
 */
@Configuration
public class ObjectMapper {
	
	@Bean
	public ModelMapper getMapper() {
		
		return new ModelMapper();
	}
}


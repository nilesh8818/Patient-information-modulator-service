package com.company.patinet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @since 06-Jul-2019 7:57:44 pm
 *
 */
@SpringBootApplication
public class PatientInformationServiceModulatorApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PatientInformationServiceModulatorApplication.class, args);
	}

	/**
	 * @return rest template instance;
	 */
	@Bean(name ="loadBalancedPatientModulatorService")
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}

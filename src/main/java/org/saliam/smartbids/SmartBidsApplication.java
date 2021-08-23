package org.saliam.smartbids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ={ "org.saliam.smartbids.*"})
@EntityScan(basePackages ={ "org.saliam.smartbids.*"})
public class SmartBidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartBidsApplication.class, args);
	}

}

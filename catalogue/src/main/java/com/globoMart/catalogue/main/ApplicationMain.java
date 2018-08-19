package com.globoMart.catalogue.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.globoMart.catalogue.domain.Product;
import com.globoMart.catalogue.repository.ProductRepository;

@SpringBootApplication
@ComponentScan("com.globoMart.catalogue")
@EnableJpaRepositories("com.globoMart.catalogue.repository")
@EntityScan("com.globoMart.catalogue.domain")
public class ApplicationMain {

	private static final Logger logger = LogManager.getLogger(ApplicationMain.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}

	/*
	 * CommandLineRunner method marked as a @Bean and this runs on start up.
	 * It uploads dummy data to the DB for testing.
	 * It also check if data is successfully inserted into DB.
	 * 
	 * Note: Please remove this method before deploying in Production. 
	 */
	
	@Bean
	public CommandLineRunner loadData(ProductRepository proRepo) {
		return (args) -> {
			// save few products
			proRepo.save(new Product("a01", "Levis", 1700, 10, "cloth", "jeans pant"));
			proRepo.save(new Product("a02", "Fog", 350, 5, "deo", "deodorant"));
			proRepo.save(new Product("a03", "Shot", 320, 7, "deo", "deodorant"));
			proRepo.save(new Product("a04", "Tupperware", 120, 12, "plastic", "TupperWare water bottle"));
			proRepo.save(new Product("a05", "Signoraware", 100, 16, "plastic", "Signoraware water bottle"));

			// fetch all products
			logger.info("");
			logger.info("Customers found with findAll():");
			logger.info("________________________________________________________ ");
			for (Product product : proRepo.findAll()) {
				logger.info(product.toString());
			}
			logger.info("________________________________________________________");

			// fetch a product by ID
			Product product = proRepo.findByProductId("a01");
			logger.info("");
			logger.info("Customer found with findOne(a01):");
			logger.info("");
			logger.info(product.toString());
			logger.info("");
		};
	}

}

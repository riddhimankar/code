package com.globoMart.catalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globoMart.catalogue.domain.Product;
import com.globoMart.catalogue.repository.ProductRepository;

@Service
public class CatalogueService {

	private static final Logger logger = LogManager.getLogger(CatalogueService.class);

	@Autowired
	ProductRepository productRepo;

	public List<Product> getALLProducts() {

		List<Product> products = new ArrayList<>();
		productRepo.findAll().forEach(p -> products.add(p));
		return products;
	}

	public List<Product> getProductsByType(String type) {
		logger.info("Get product by Type: {} ", type);
		List<Product> products = productRepo.findByType(type);
		if (null == products || products.isEmpty())
			logger.info("Received products: {} ", "not available");
		else
			products.forEach(p -> logger.info("Received product: {} ", p));
		return products;
	}

	public void addProduct(Product product) {
		logger.info("Add request for product: {} ", product.toString());
		productRepo.save(product);
		logger.info("Add request is successful");
	}

	public Product getProduct(String id) {
		logger.info("Get request for product id: {} ", id);
		Product product = productRepo.findByProductId(id);
		if (null == product)
			logger.info("Received product: {} ", "not available");
		else
			logger.info("Received product: {} ", product.toString());
		return product;
	}

	public Product updateProduct(Product product) {
		logger.info("Update request for product: {} ", product.toString());
		Product updatedProduct = productRepo.save(product);
		logger.info("After update product: {} ", product.toString());
		return updatedProduct;
	}

	public void deleteProduct(String id) {
		logger.info("Delete request for id: {} ", id);
		productRepo.deleteById(id);
		logger.info("Delete request is successful");
	}
}

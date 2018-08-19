package com.globoMart.catalogue.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globoMart.catalogue.domain.Product;
import com.globoMart.catalogue.service.CatalogueService;

@RestController
public class CatalogueResource {

	@Autowired
	CatalogueService catalogueService;

	
	@RequestMapping("/")
	public String test() {
		return "Welcome! to Catalogue service.";

	}
	
	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return catalogueService.getALLProducts();

	}
	
	@RequestMapping("/products/{type}")
	public List<Product> getProductsByType(@PathVariable String type) {
		return catalogueService.getProductsByType(type);

	}
	
	@RequestMapping("/product/{id}")
	public Product getProduct(@PathVariable String id) {
		return catalogueService.getProduct(id);

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public void addProduct(@RequestBody Product product) {
		catalogueService.addProduct(product);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/product")
	public Product updateProduct(@RequestBody Product product) {
		return catalogueService.updateProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
	public void updateProduct(@PathVariable String id) {
		catalogueService.deleteProduct(id);
	}
}

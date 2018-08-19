package com.globoMart.catalogue.repository;
        
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globoMart.catalogue.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
	public Product findByProductId(String id);
	public List<Product> findByType(String type);
}

package com.globoMart.catalogue.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private String productId;
	private String name;
	private float price;
	private int availability;
	private String type;
	private String description;

	public Product() {
	}

	
	public Product(String productId, String name, float price, int availability, String type, String description) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.availability = availability;
		this.type = type;
		this.description = description;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return productId + ", " + name + ", " + availability + ", " + price + ", " + type + ", "  + description;
	}
}

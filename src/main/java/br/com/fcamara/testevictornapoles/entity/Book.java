package br.com.fcamara.testevictornapoles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	private Long sku;
	@Column
	private String name;
	@Column
	private String brand;
	@Column
	private Double price;

	public Book() {
		super();
	}

	public Book(Long sku, String name, String brand, Double price) {
		super();
		this.sku = sku;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	

}

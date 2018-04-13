package br.com.fcamara.testevictornapoles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQuery(name = "Book.findByPriceLessOrEqual", query = "SELECT b from Book b where b.price <= COALESCE(:price, b.price)")
@Table(name="book", uniqueConstraints= {@UniqueConstraint(name="uk_sku", columnNames = {"sku"})})
public class Book {
	@Id
	@SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
	private Long id;
	@Column
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

package br.com.fcamara.testevictornapoles.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.fcamara.testevictornapoles.component.BaseDto;
import br.com.fcamara.testevictornapoles.entity.Book;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto extends BaseDto<Book> {
	private Long sku;
	private String name;
	private String brand;
	private PriceDto price;

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

	public PriceDto getPrice() {
		return price;
	}

	public void setPrice(PriceDto price) {
		this.price = price;
	}


	@Override
	public Book convertDtoToEntity() {
		Double price = null;
		if (this.price != null && this.price.getBestPrice() != null && this.price.getBestPrice().getValue() != null
				&& !this.price.getBestPrice().getValue().isEmpty()) {
			
			price = Double.valueOf(this.price.getBestPrice().getValue().replace(".", "").replace(",", "."));
		
		}
		
		Book book = new Book(getSku(), getName(), getBrand(), price);
		
		return book;
	}

}

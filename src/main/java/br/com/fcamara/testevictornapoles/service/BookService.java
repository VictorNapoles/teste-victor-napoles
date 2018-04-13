package br.com.fcamara.testevictornapoles.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.fcamara.testevictornapoles.entity.Book;

public interface BookService {
	
	Book findBySku(Long sku) throws Exception;
	
	List<Book> findByPriceLessOrEqual(Double price, Pageable pageable);
	
	void save(Long sku) throws Exception;
	
	void delete(Long sku) throws Exception;

}

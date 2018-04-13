package br.com.fcamara.testevictornapoles.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fcamara.testevictornapoles.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	Book findBySku(Long sku);
	
	@Query(name="Book.findByPriceLessOrEqual")
	List<Book> findByPriceLessOrEqual(@Param("price") Double price);
	
	@Query(name="Book.findByPriceLessOrEqual")
	Page<Book> findByPriceLessOrEqual(@Param("price") Double price, Pageable pageable);
	
	Page<Book> findAll(Pageable pageable);

}

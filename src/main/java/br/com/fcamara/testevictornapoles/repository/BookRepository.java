package br.com.fcamara.testevictornapoles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fcamara.testevictornapoles.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	Book findBySku(Long sku);
	
	@Query("SELECT b from Book b where b.price <= COALESCE(:price, b.price)")
	List<Book> findByPriceLessOrEqual(@Param("price") Double price);

}

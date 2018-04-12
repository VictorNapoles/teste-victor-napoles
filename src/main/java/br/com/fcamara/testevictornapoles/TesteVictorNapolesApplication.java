package br.com.fcamara.testevictornapoles;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.fcamara.testevictornapoles.entity.Book;
import br.com.fcamara.testevictornapoles.repository.BookRepository;

@SpringBootApplication
public class TesteVictorNapolesApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TesteVictorNapolesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TesteVictorNapolesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			// save a couple of Books
			long sku = 123456789L;
			repository.save(new Book(sku, "Book name 1", "Book brand 1", 1.99));
			repository.save(new Book(223456789L, "Book name 2", "Book brand 2", 2.99));
			repository.save(new Book(323456789L, "Book name 3", "Book brand 3", 3.99));
			
			List<Book> books = repository.findByPriceLessOrEqual(1.50);
			books.stream().forEach(b -> {
				log.info("Book name: ".concat(b.getName()));
			});

//			Book book = repository.findBySku(sku);
//			log.info("Book name: ".concat(book.getName()));
//			log.info("Book brand: ".concat(book.getBrand()));
//			log.info("Delete Book: ".concat(book.getName()));
//			repository.delete(book);
//			log.info("Book Deleted");
			

		};
	}
}

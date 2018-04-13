package br.com.fcamara.testevictornapoles.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.fcamara.testevictornapoles.component.Messages;
import br.com.fcamara.testevictornapoles.dto.BookDto;
import br.com.fcamara.testevictornapoles.entity.Book;
import br.com.fcamara.testevictornapoles.repository.BookRepository;
import br.com.fcamara.testevictornapoles.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private static final String URL_API_SARAIVA = "https://api.saraiva.com.br/sc/produto/pdp/%s/0/0/1/";
	
	@Autowired
	Messages messages;
	
	@Autowired
	BookRepository bookRepository;

	public BookServiceImpl() {
		super();
	}

	public BookServiceImpl(Messages messages, BookRepository bookRepository) {
		super();
		this.messages = messages;
		this.bookRepository = bookRepository;
	}

	@Override
	public Book findBySku(Long sku) throws Exception {
		if(sku == null) {
			throw new Exception(messages.get("erro.sku.nao.informado"));
		}
		
		return bookRepository.findBySku(sku);
	}

	@Override
	public List<Book> findByPriceLessOrEqual(Double price, Pageable pageable) {
		List<Book> books = new ArrayList<Book>();
		
		if(price == null) {
			if(pageable == null) {
				Iterable<Book> allBooks = bookRepository.findAll();
				allBooks.forEach(books::add);
			
			}else {
				Page<Book> allBooks = bookRepository.findAll(pageable);
				allBooks.forEach(books::add);
			}
		}else {
			if(pageable == null) {
				books = bookRepository.findByPriceLessOrEqual(price);
			
			}else {
				Page<Book> allBooks = bookRepository.findByPriceLessOrEqual(price,pageable);
				allBooks.forEach(books::add);
			}
		}
		
		return books;
	}

	@Override
	public void save(Long sku) throws Exception {
		if(sku == null) {
			throw new Exception(messages.get("erro.sku.nao.informado"));
		}
		
		RestTemplate restTemplate = new RestTemplate();
		BookDto book = restTemplate.getForObject(String.format(URL_API_SARAIVA, sku), BookDto.class);
		
		bookRepository.save(book.convertDtoToEntity());
	}
	
	@Override
	public void delete(Long sku) throws Exception {
		if(sku == null) {
			throw new Exception(messages.get("erro.sku.nao.informado"));
		}

		Book book = bookRepository.findBySku(sku);
		bookRepository.delete(book);
	}
}
package br.com.fcamara.testevictornapoles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fcamara.testevictornapoles.entity.Book;
import br.com.fcamara.testevictornapoles.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	public BookController() {
		super();
	}

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestParam(value= "sku", required=true)Long sku) {
		try {
			bookService.save(sku);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{sku}")
	public ResponseEntity<String> delete(@PathVariable(value= "sku", required=true)Long sku) {
		try {
			bookService.delete(sku);
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> list(@RequestParam(value= "price", required=false)Double price,@RequestParam(value= "limit", required=false)Integer limit) {
		try {
			Pageable pageable = null;
			if(limit != null) {
				pageable= PageRequest.of(0, limit);
			}
			return new ResponseEntity<Object>(bookService.findByPriceLessOrEqual(price, pageable),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{sku}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> find(@PathVariable(value= "sku", required=true)Long sku) {
		try {
			return new ResponseEntity<Object>(bookService.findBySku(sku),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

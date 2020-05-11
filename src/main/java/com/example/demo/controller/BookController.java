package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.model.Books;

@RestController
@RequestMapping(value = "api")
public class BookController {
	Books books;
	public List<Book> catalog;
	public BookController() {
		catalog = new ArrayList<Book>();
		catalog.add(new Book(1, "Spring core", 300.00));
		catalog.add(new Book(2, "Spring Cloud", 800.00));
		catalog.add(new Book(3, "Spring Boot", 1300.00));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "books")
	public Books getAllBooks() {
		books = new Books();
		books.setBook(catalog);
		return books;
	}

	@RequestMapping(method = RequestMethod.GET, value = "books/book/{bid}", produces= {"application/json","application/xml"})
	public Book getBookById(@PathVariable("bid") Integer bookid) {
		Book book = null;
		for(Book b : catalog) {
			if(b.getBookId() == bookid) {
				book = b;
				break;
			}
		}
		return book;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "books/book/{bid}")
	public String deleteBookById(@PathVariable("bid") Integer bookid) {
		Book book = null;
		for(Book b : catalog) {
			if(b.getBookId() == bookid) {
				book = b;
				catalog.remove(b);
				break;
			}
		}
		return book==null ? "Book "+bookid+" not found" : "Book "+bookid+" deleted successful";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "books/book")
	public Book addBook(@RequestBody Book book) {
		catalog.add(book);
		return book;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "books/book")
	public String updateBook(@RequestBody Book book) {
		for(Book b : catalog) {
			if(b.getBookId() == book.getBookId()) {
				catalog.remove(b);
				break;
			}
		}
		catalog.add(book);
		return book==null ? "Book "+book.getBookId()+" not found" : "Book "+book.getBookId()+" updated successful";
	}
	
	@RequestMapping(value = "msg")
	public String getMessage() {
		return "Hello World";
	}

}

package com.example.demo.model;
//JAX-B --> Java API for XML Binding
import javax.xml.bind.annotation.*;
/*
 * 
 * <Book>
 * 	  <boodId></boodId>
 *    <title></title>
 *    <price></price>
 * </Book>
 */
@XmlRootElement
public class Book {
	
	private Integer bookId;
	private String title;
	private Double price;
	
	public Book() {
		
	}
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Book(Integer bookId, String title, Double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
	}
	
	
}

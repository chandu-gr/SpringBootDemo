package com.example.demo.model;
import java.util.List;

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
public class Books {
	
	private List<Book> book;

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
}

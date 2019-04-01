package com.fsd.web.springbootwebdemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.web.springbootwebdemo.book.BookService;
import com.fsd.web.springbootwebdemo.model.Book;
import com.fsd.web.springbootwebdemo.response.BookResponse;

import io.swagger.annotations.Api;

@Api(value="BMS", description="Book Store Management System")
@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {
	

	@Autowired
	private BookService bookService;
	
//	@Autowired
//	private ApplicationContext ac;
	
	@GetMapping(value="/all", produces= {"application/xml","application/json"})	
	public ResponseEntity<List<Book>> getSubjectDetails() {
//		 	HttpHeaders responseHeaders = new HttpHeaders();
//		    responseHeaders.setAccessControlAllowCredentials(true);	
		   // return ResponseEntity.ok(bookService.getBook());
			return ResponseEntity.ok().body(bookService.getBook());
			//return new ResponseEntity(ResponseEntity.ok(bookService.getBook()),responseHeaders,HttpStatus.OK);
		
	}
	
	@GetMapping("/{book_id}")	
	public ResponseEntity<Book> getBookById(@PathVariable int book_id) {
		return ResponseEntity.ok(bookService.getBookById(book_id));
		 
	}
	
	@PostMapping(value="/add", consumes= {"application/xml","application/json"}, produces= {"application/xml","application/json"})	
	public ResponseEntity addBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.addBook(book));
		
	}
	
	@DeleteMapping("/delete/{book_id}")	
	public String deleteBookById(@PathVariable String book_id) {
		return bookService.deleteBookById(Integer.parseInt(book_id));
	}
	
	
	@PutMapping(value="/update", consumes= {"application/xml","application/json"}, produces= {"application/xml","application/json"})	
	public String updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
}

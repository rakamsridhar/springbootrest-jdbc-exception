package com.fsd.web.springbootwebdemo.book;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fsd.web.springbootwebdemo.model.Book;

@Service
public interface BookService {
	public List<Book> getBook();
	public Book getBookById(int book_id);
	public String addBook(Book book);
	public String deleteBookById(int book_id);
	public String updateBook(Book book);
}

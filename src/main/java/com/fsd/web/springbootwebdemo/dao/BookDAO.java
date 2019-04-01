package com.fsd.web.springbootwebdemo.dao;

import java.util.List;

import com.fsd.web.springbootwebdemo.model.Book;

public interface BookDAO {
	public List<Book> getBook();
	public Book getBookById(int book_id);
	public String addBook(Book book);
	public String deleteBookById(int book_id);
	public String updateBook(Book book);

}

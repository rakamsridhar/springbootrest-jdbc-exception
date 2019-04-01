package com.fsd.web.springbootwebdemo.dao;

import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;


import com.fsd.web.springbootwebdemo.mapper.BookMapper;
import com.fsd.web.springbootwebdemo.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Book> getBook() {
		String sql = "select * from bookstore.book";
		List<Book> books = jdbcTemplate.query(sql, new BookMapper());
		//System.out.println("Books --------> " + books);
		return books;
	}


	@Override
	public Book getBookById(int book_id) {
		String sql = "select * from bookstore.book where book_id =" + book_id;
		Book book = (Book)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Book.class));
		//System.out.println("Books --------> " + book);
		return book;
	}


	@Override
	public String addBook(Book book) {
		String sql = "insert into bookstore.book values("+ book.getBook_id() + ",'" + book.getTitle() + "'," + book.getPrice() + "," +book.getVolume() +",'"+ book.getPublishedDate()+"')";
		jdbcTemplate.execute(sql);
		return "book added successfully";
	}


	@Override
	public String deleteBookById(int book_id) {
		System.out.println("-------> Deleting book : " + book_id);
		String sql = "delete from bookstore.book where book_id =" + book_id;
		jdbcTemplate.execute(sql);
		return "book deleted successfully";
	}


	@Override
	public String updateBook(Book book) {
		String sql = "update bookstore.book set title='" + book.getTitle() +"', price=" + book.getPrice() + ", volume=" + book.getVolume() + ", published_date='" + book.getPublishedDate() + "' where book_id=" + book.getBook_id();
		jdbcTemplate.execute(sql);
		return "Book updated successfully";
	}

}

package com.fsd.web.springbootwebdemo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsd.web.springbootwebdemo.model.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setBook_id(rs.getInt("book_id"));
		book.setTitle(rs.getString("title"));
		book.setPrice(rs.getDouble("price"));
		book.setVolume(rs.getInt("volume"));
		book.setPublishedDate(rs.getDate("published_date"));
		return book;
	}

}

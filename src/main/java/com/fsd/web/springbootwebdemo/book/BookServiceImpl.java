package com.fsd.web.springbootwebdemo.book;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.web.springbootwebdemo.dao.BookDAO;
import com.fsd.web.springbootwebdemo.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;
	
//	@Autowired
//	private SessionFactory session;
	
	@Override
	public List<Book> getBook() {
		System.out.println(" ----------> Calling DAO to get book list");
		return bookDao.getBook();
	}

	@Override
	public Book getBookById(int book_id) {		
		return bookDao.getBookById(book_id);
	}

	@Override
	public String addBook(Book book) {		
		return bookDao.addBook(book);
//		session.getTransaction();
//		session.save(book);
//		session.close();
//		return "book saved successfully";
		
	}

	@Override
	public String deleteBookById(int book_id) {		
		return bookDao.deleteBookById(book_id);
	}

	@Override
	public String updateBook(Book book) {		
		return bookDao.updateBook(book);
	}
	
	

}

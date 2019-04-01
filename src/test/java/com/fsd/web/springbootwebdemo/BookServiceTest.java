package com.fsd.web.springbootwebdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.web.springbootwebdemo.book.BookService;
import com.fsd.web.springbootwebdemo.book.BookServiceImpl;
import com.fsd.web.springbootwebdemo.dao.BookDAO;
import com.fsd.web.springbootwebdemo.model.Book;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
	
	@MockBean
	private BookDAO bookDao;
	
	@Autowired
	private BookServiceImpl bookService;
	
	private List<Book> books;
	
    @Before
    public void setup() throws Exception {
        this.books  = getTestData();
    }
	
	@Test
	public void testGetBook() {
		Mockito.when(bookDao.getBook()).thenReturn(getTestData());
		List<Book> books = bookService.getBook();
		assertEquals(2, books.size());	
		//assertThat(bookService.getBook(), containsInAnyOrder(new Book(101, "Documentary", 200, 2, new Date(2011,10,01))));;		
	}
	
    @Test
    public void getBookByIdTest()
    {
    	Mockito.when(bookDao.getBookById(1)).thenReturn(new Book(101, "Documentary", 200, 2, new Date(2011,10,01)));
         
        Book book = bookDao.getBookById(1);
         
        assertEquals("Documentary", book.getTitle());
        assertEquals(101, book.getBook_id());        
    }
    
    @Test
    public void addBookTest()
    {
        Book book = new Book(101, "Documentary", 200, 2, new Date(2011,10,01));
        Mockito.when(bookDao.addBook(book)).thenReturn("book added successfully");
        //bookDao.addBook(book);
         
        assertEquals(bookDao.addBook(book), "book added successfully");
    }
	
	private List<Book> getTestData(){
    	List<Book> books = new ArrayList<Book>();
    	Book b1=new Book();
		b1.setBook_id(101);
		b1.setTitle("Documentary");
		b1.setPrice(new Double(200));
		b1.setVolume(2);
		b1.setPublishedDate(new java.sql.Date(2011, 10, 01));
		
		
    	Book b2=new Book();
		b2.setBook_id(102);
		b2.setTitle("Computers");
		b2.setPrice(new Double(300));
		b2.setVolume(3);
		b2.setPublishedDate(new java.sql.Date(2012, 10, 02));
		
		books.add(b1);
		books.add(b2);
		
		return books;
		
	}
	

}

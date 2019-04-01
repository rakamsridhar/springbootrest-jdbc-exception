package com.fsd.web.springbootwebdemo.model;



import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

@Component
@XmlRootElement
public class Book {
	private int book_id;
	private String title;
	private double price;
	private int volume;
//	@JsonFormat(pattern="yyyy-MM-dd")
	private Date publishedDate;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {		
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishedDate=" + publishedDate + "]";
	}
	public Book(int book_id, String title, double price, int volume, Date publishedDate) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishedDate = publishedDate;
	}
	
	public Book() {
		
	}

}

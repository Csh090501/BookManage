package org.service;

import java.util.List;

import org.dao.BookDao;
import org.model.Book;

public class BookService {
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public Book selectBook(String ISBN){
		return bookDao.selectBook(ISBN);
	}
	
	public Book queryBook1(String bookName){
		return bookDao.queryBook1(bookName);
	}
	
	public List queryBook2(String bookName ,int pageSize ,int pageNow){
		return bookDao.queryBook2(bookName, pageSize, pageNow);
	}
	
	public int selectBookSize(String bookName){
		return bookDao.selectBookSize(bookName);
	}
	
	public boolean updateBook(Book book){
		return bookDao.updateBook(book);
	}
	
	public boolean addBook(Book book){
		return bookDao.addBook(book);
	}
	
	public boolean deleteBook(Book book){
		return bookDao.deleteBook(book);
	}
}

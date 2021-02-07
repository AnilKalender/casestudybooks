package com.books.services;

import java.util.List;

import com.books.model.Book;

public interface IBookService {
	
	List<Book> getList() throws Exception;
	List<Book> findByName(String bookName) throws Exception;
	Book update(Book book) throws Exception;
	Book add(Book book) throws Exception;
	void delete(Long id) throws Exception;
	
}

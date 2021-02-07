package com.books.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.BookRepository;
import com.books.model.Book;

@Service
public class BookServiceImpl implements IBookService {

	private static final String ID_NON_NULL_MSG = "ID Cannot Be Null In Update Operations.";
	private static final String ID_NULL_MSG = "ID Must Be Null In Save Operations.";

	@Autowired
	private BookRepository repository;

	@Override
	public List<Book> getList() throws Exception{
		return convertIterableToList(repository.findAll());
	}

	@Override
	public List<Book> findByName(String bookName) throws Exception{
		return convertIterableToList(repository.findByNameContains(bookName));
	}

	@Override
	public Book update(Book book) throws Exception{
		nullControl(book.getId());
		return save(book);
	}

	@Override
	public Book add(Book book) throws Exception{
		nonNullControl(book.getId());
		return save(book);
	}

	@Override
	public void delete(Long id) throws Exception {
		nullControl(id);
		repository.deleteById(id);
	}

	private Book save(Book book) throws Exception{
		return repository.save(book);
	}
	
	private List<Book> convertIterableToList(Iterable<Book> iterableBooks) {
		List<Book> books = new ArrayList<Book>();
		iterableBooks.forEach(book -> books.add(book));
		return books;
	}
	
	private void nonNullControl(Long bookId) throws Exception {
		if(Objects.nonNull(bookId)) {
			throw new Exception(ID_NULL_MSG);
		}
	}
	
	private void nullControl(Long bookId) throws Exception {
		Objects.requireNonNull(bookId, ID_NON_NULL_MSG);
	}
}

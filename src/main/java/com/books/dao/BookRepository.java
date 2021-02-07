package com.books.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByNameContains(String name);
}

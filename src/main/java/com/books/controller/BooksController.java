
package com.books.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Book;
import com.books.model.ResponseModel;
import com.books.services.IBookService;

@RestController
@RequestMapping(value = "/restful/books", produces = "application/json")
public class BooksController {

	@Autowired
	private IBookService bookService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BooksController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseModel getList() throws Exception {
		try {
			return ResponseModel.createSuccessResponseWithData(bookService.getList());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseModel.createErrorResponseWithData(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/findByName/{bookName}", method = RequestMethod.GET)
	public ResponseModel getBooksByName(@PathVariable("bookName") String bookName) throws Exception {
		try {
			return ResponseModel.createSuccessResponseWithData(bookService.findByName(bookName));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseModel.createErrorResponseWithData(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseModel update(@RequestBody Book book) throws Exception {
		try {
			return ResponseModel.createSuccessResponseWithData(bookService.update(book));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseModel.createErrorResponseWithData(e.getMessage());
		}
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseModel add(@RequestBody Book book) throws Exception {
		try {
			return ResponseModel.createSuccessResponseWithData(bookService.add(book));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseModel.createErrorResponseWithData(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.DELETE)
	public ResponseModel delete(@PathVariable("bookId") Long bookId) throws Exception {
		try {
			bookService.delete(bookId);
			return ResponseModel.createSuccessResponse();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseModel.createErrorResponseWithData(e.getMessage());
		}
	}
}

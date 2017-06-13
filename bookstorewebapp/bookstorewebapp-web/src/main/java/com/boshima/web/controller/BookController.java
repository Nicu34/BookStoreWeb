package com.boshima.web.controller;

import com.boshima.core.model.Book;
import com.boshima.core.service.BookService;
import com.boshima.web.converter.BookConverter;
import com.boshima.web.dto.BookDto;
import com.boshima.web.dto.BooksDto;
import com.boshima.web.dto.EmptyJsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nicu on 30/04/2017.
 */
@RestController
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    protected BookService bookService;

    @Autowired
    private BookConverter bookConverter;

    @RequestMapping(method = RequestMethod.GET)
    public BooksDto getBooks() {
        log.trace("getBooks --- method entered");

        List<Book> books = bookService.findAll();

        log.trace("getBooks: Books={}", books);

        return new BooksDto(bookConverter.convertModelsToDtos(books));
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
    public BookDto updateBook(
            @PathVariable final Long bookId,
            @RequestBody final BookDto bookDto) {
        log.trace("updateBook: bookId={}, bookDto={}", bookId, bookDto);

        Book book = bookService.updateBook(bookId,
                bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPrice());

        BookDto result = bookConverter.convertModelToDto(book);

        log.trace("updateBook: result={}", result);

        return result;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public BookDto createBook(
            @RequestBody final BookDto bookDto) {
        log.trace("createBook: bookDto={}", bookDto);

        Book book = bookService.createBook(bookDto.getTitle(),
                bookDto.getAuthor(), bookDto.getPrice());

        BookDto result = bookConverter.convertModelToDto(book);

        log.trace("createBook: result={}", result);

        return result;
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@PathVariable final Long bookId) {
        log.trace("deleteBook: bookId={}", bookId);

        bookService.deleteBook(bookId);

        log.trace("deleteBook - method end");

        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }

}

package com.boshima.core.service;

import com.boshima.core.model.Book;
import com.boshima.core.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nicu on 30/04/2017.
 */
@Service
public class BookServiceImpl implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    protected BookRepository bookRepository;

    @Override
    @Transactional
    public Book findOne(Long id){
        log.trace("findAll");

        Book book = bookRepository.findOne(id);

        log.trace("findAll: book={}", book);

        return book;
    }

    @Override
    @Transactional
    public List<Book> findAll(){
        log.trace("findAll");

        List<Book> books = bookRepository.findAll();

        log.trace("findAll: books={}", books);

        return books;
    }

    @Override
    @Transactional
    public Book updateBook(Long bookId, String title, String author, double price) {
        log.trace("updateBook: bookId={}, title={}, author={}, price={}", bookId, title, author, price);

        Book book = bookRepository.findOne(bookId);
        book.setAuthor(author);
        book.setTitle(title);
        book.setPrice(price);

        log.trace("updateBook: book={}", book);

        return book;
    }

    @Override
    public Book createBook(String title, String author, double price) {
        log.trace("createBook: id={}, title={}, author={}, price={}", title, author, price);

        Book book = new Book(title, author, price);
        book = bookRepository.save(book);

        log.trace("createBook: book={}", book);

        return book;
    }

    @Override
    public void deleteBook(Long bookId) {
        log.trace("deleteBook: bookId={}", bookId);

        bookRepository.delete(bookId);

        log.trace("deleteBook - method end");
    }
}

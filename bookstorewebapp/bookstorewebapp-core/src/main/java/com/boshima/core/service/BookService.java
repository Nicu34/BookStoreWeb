package com.boshima.core.service;

import com.boshima.core.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nicu on 30/04/2017.
 */
public interface BookService {

    Book findOne(Long id);

    List<Book> findAll();

    Book updateBook(Long bookId, String title, String author, double price);

    Book createBook(String title, String author, double price);

    void deleteBook(Long bookId);

}

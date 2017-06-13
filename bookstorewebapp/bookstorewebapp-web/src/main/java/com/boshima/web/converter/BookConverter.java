package com.boshima.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.boshima.core.model.Book;
import com.boshima.web.dto.BookDto;

/**
 * Created by paul on 5/1/2017.
 */
@Component
public class BookConverter extends BaseConverter<Book, BookDto> {

    private static final Logger log = LoggerFactory.getLogger(BookConverter.class);

    @Override
    public BookDto convertModelToDto(Book book) {
        BookDto bookDto = new BookDto(book.getTitle(), book.getAuthor(), book.getPrice());
        bookDto.setId(book.getId());
        return bookDto;
    }
}
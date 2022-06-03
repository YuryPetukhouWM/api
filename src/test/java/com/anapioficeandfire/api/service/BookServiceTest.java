package com.anapioficeandfire.api.service;

import com.anapioficeandfire.api.mapper.BookMapperImpl;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.model.enums.BookMediaType;
import com.anapioficeandfire.api.repository.BookRepository;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class BookServiceTest {

    private BookService service;
    private BookRepository repository = Mockito.mock(BookRepository.class);
    private Book TEST_BOOK;


    @BeforeEach
    void init() {
        TEST_BOOK = new Book();
        TEST_BOOK.setUrl("http://localhost:8080/api/books/1");
        TEST_BOOK.setMediaType(BookMediaType.HARDCOVER);
        String[] authors = {"George R. R. Martin"};
        TEST_BOOK.setAuthors(authors.toString());
        TEST_BOOK.setCountry("United States");
        TEST_BOOK.setIsbn("978-0553103540");
        TEST_BOOK.setPublisher("Bantam Books");
        TEST_BOOK.setNumberOfPages(694);
        TEST_BOOK.setName("A Game of Thrones");
        TEST_BOOK.setReleased("1996-08-01T00:00:00");
        TEST_BOOK.setCharacters(null);
        TEST_BOOK.setPovCharacters(null);
        service = new BookServiceImpl(repository, new BookMapperImpl());
    }

    @Test
    public void givenBookService_shouldReturnTestBook() {
        Mockito.when(repository.findAll()).thenReturn(new PageImpl<>(List.of(TEST_BOOK)));

        var books = service.findAll(1,10, null, null, null);

        assertThat(books.size(), equalTo(1));
        assertThat(books.get(1), equalTo(TEST_BOOK));

    }
}

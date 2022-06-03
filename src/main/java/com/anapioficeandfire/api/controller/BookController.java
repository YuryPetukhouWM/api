package com.anapioficeandfire.api.controller;

import com.anapioficeandfire.api.dto.BookDto;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface BookController {

    ResponseEntity<List<BookDto>> findAll(int page,
                                          int size,
                                          String name,
                                          LocalDate fromReleaseDate,
                                          LocalDate toReleaseDate);

    ResponseEntity<BookDto> findByUrl(HttpServletRequest request);
}

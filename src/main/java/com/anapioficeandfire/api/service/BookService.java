package com.anapioficeandfire.api.service;

import com.anapioficeandfire.api.dto.BookDto;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> findAll(int page,
                          int size,
                          String name,
                          LocalDate fromReleaseDate,
                          LocalDate toReleaseDate);

    Optional<BookDto> findByUrl(String requestURI);
}

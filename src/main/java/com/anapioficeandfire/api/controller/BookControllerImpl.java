package com.anapioficeandfire.api.controller;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.service.BookService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookControllerImpl implements BookController{

    private BookService bookService;

    @GetMapping(path = "")
    @Override
    public ResponseEntity<List<BookDto>> findAll(@RequestParam(name = "page", defaultValue = "1") int page,
                                 @RequestParam(name = "pageSize", defaultValue = "10") int size,
                                 @RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "fromReleaseDate", required = false)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromReleaseDate,
                                 @RequestParam(name = "toReleaseDate", required = false)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toReleaseDate) {
        return ResponseEntity.ok(bookService.findAll(page, size, name, fromReleaseDate, toReleaseDate));
    }

    @GetMapping(path = "/{urlPart}")
    @Override
    public ResponseEntity<BookDto> findByUrl(HttpServletRequest request) {
        return bookService.findByUrl(request.getRequestURL().toString()).map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}

package com.anapioficeandfire.api.service;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.mapper.BookMapper;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.repository.BookRepository;
import com.anapioficeandfire.api.repository.SearchCriteria;
import com.anapioficeandfire.api.repository.SearchSpecification;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private BookRepository repository;
    private BookMapper mapper;

    @Override
    public List<BookDto> findAll(int page, int size, String name, LocalDate fromReleaseDate, LocalDate toReleaseDate) {
        var searchSpecfication = buildSearchSpecification(name, fromReleaseDate, toReleaseDate);
        return repository.findAll(searchSpecfication, PageRequest.of(page-1, size)).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<BookDto> findByUrl(String requestURI) {
        return repository.findById(requestURI).map(mapper::toDto);
    }

    private Specification<Book> buildSearchSpecification(String name, LocalDate fromReleaseDate, LocalDate toReleaseDate) {
        var specifications = new ArrayList<Specification<Book>>();
        if (Objects.nonNull(name)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("name", ":", name)));
        }
        if (Objects.nonNull(fromReleaseDate)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("released", ">", fromReleaseDate)));
        }
        if (Objects.nonNull(toReleaseDate)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("released", "<", toReleaseDate)));
        }
        return specifications.stream().reduce((x,y) -> x.and(y)).orElse(null);
    }
}

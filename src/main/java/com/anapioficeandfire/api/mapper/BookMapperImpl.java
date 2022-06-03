package com.anapioficeandfire.api.mapper;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.model.CharacterPerson;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper{
    @Override
    public BookDto toDto(Book book) {
        var builder = BookDto.builder();
        builder.authors(MappingUtils.parseArray(book.getAuthors()));
        builder.characters(book.getCharacters().stream()
                .map(CharacterPerson::getUrl)
                .toList());
        builder.country(Objects.toString(book.getCountry(), ""));
        builder.povCharacters(
                Optional.ofNullable(book.getPovCharacters()).orElse(Collections.emptyList())
                        .stream()
                        .map(CharacterPerson::getUrl)
                        .toList());
        builder.mediaType(Objects.isNull(book.getMediaType()) ? ""
                : book.getMediaType().getDisplayName());
        builder.numberOfPages(Optional.ofNullable(book.getNumberOfPages()).orElse(0));
        builder.isbn(Objects.toString(book.getIsbn(), ""));
        builder.publisher(Objects.toString(book.getPublisher(), ""));
        builder.released(Objects.isNull(book.getReleased()) ? "" : book.getReleased());
        var dto = builder.build();
        dto.setUrl(book.getUrl());
        dto.setName(Objects.toString(book.getName(), ""));
        return dto;
    }
}

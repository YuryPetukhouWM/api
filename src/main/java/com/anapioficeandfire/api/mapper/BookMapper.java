package com.anapioficeandfire.api.mapper;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BookMapper {
    BookDto toDto(Book book);
}

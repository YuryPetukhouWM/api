package com.anapioficeandfire.api.mapper;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.dto.CharacterDto;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.model.CharacterPerson;
import org.mapstruct.Mapper;

@Mapper
public interface CharacterMapper {
    CharacterDto toDto(CharacterPerson character);
}

package com.anapioficeandfire.api.mapper;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.dto.CharacterDto;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.model.CharacterPerson;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapperImpl implements CharacterMapper {
    @Override
    public CharacterDto toDto(CharacterPerson character) {
        var builder = CharacterDto.builder();
        builder.gender(Objects.isNull(character.getGender()) ? ""
                : character.getGender().getAbbreviation());
        builder.culture(Objects.toString(character.getCulture(), ""));
        builder.titles(MappingUtils.parseArray(character.getTitles()));
        builder.aliases(MappingUtils.parseArray(character.getAliases()));
        builder.born(Objects.toString(character.getBorn(), ""));
        builder.died(Objects.toString(character.getDied(), ""));
        builder.allegiances(MappingUtils.parseArray(character.getAllegiances()));
        builder.father(Objects.isNull(character.getFather()) ? ""
                : character.getFather().getUrl());
        builder.mother(Objects.isNull(character.getMother()) ? ""
                : character.getMother().getUrl());
        builder.spouse(Objects.isNull(character.getSpouse()) ? Collections.emptyList()
                : character.getSpouse().stream().map(CharacterPerson::getUrl).toList());
        builder.books(Objects.isNull(character.getBooks()) ? Collections.emptyList()
                : character.getBooks().stream().map(Book::getUrl).toList());
        builder.povBooks(Objects.isNull(character.getPovBooks()) ? Collections.emptyList()
                : character.getPovBooks().stream().map(Book::getUrl).toList());
        builder.tvSeries(MappingUtils.parseArray(character.getTitles()));
        builder.playedBy(MappingUtils.parseArray(character.getPlayedBy()));
        var dto = builder.build();
        dto.setUrl(character.getUrl());
        dto.setName(Objects.toString(character.getName(), ""));
        return dto;
    }
}

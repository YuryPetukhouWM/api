package com.anapioficeandfire.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto extends ApiResourceDto {
    String isbn;
    List<String> authors;
    Integer numberOfPages;
    String publisher;
    String country;
    String mediaType;
    String released;
    List<String> characters;
    List<String> povCharacters;
}

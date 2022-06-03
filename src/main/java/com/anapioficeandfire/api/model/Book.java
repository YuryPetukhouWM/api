package com.anapioficeandfire.api.model;

import com.anapioficeandfire.api.model.enums.BookMediaType;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity(name = "books")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Book extends ApiResource {
    String isbn;
    String authors;
    Integer numberOfPages;
    String publisher;
    String country;
    @Enumerated(EnumType.STRING)
    BookMediaType mediaType;
    String released;
    @ManyToMany
    @JoinTable(
            name = "book_character",
            joinColumns = @JoinColumn(name = "book_url"),
            inverseJoinColumns = @JoinColumn(name = "character_url"))
    @JsonProperty("characters")
    List<CharacterPerson> characters;
    @ManyToMany
    @JoinTable(
            name = "book_character_pov",
            joinColumns = @JoinColumn(name = "book_url"),
            inverseJoinColumns = @JoinColumn(name = "character_url"))
    @JsonProperty("povCharacters")
    List<CharacterPerson> povCharacters;
}

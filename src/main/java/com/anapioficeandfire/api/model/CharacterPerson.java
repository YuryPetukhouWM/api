package com.anapioficeandfire.api.model;

import com.anapioficeandfire.api.model.enums.Gender;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "characters")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CharacterPerson extends ApiResource {
    @Enumerated(EnumType.STRING)
    Gender gender;
    String culture;
    String born;
    String died;
    String titles;
    String aliases;
    @ManyToOne
    @JoinColumn(name = "father_url")
    CharacterPerson father;
    @ManyToOne
    @JoinColumn(name = "mother_url")
    CharacterPerson mother;
    @ManyToMany
    @JoinTable(
            name = "character_spouses",
            joinColumns = @JoinColumn(name = "spouse1_url"),
            inverseJoinColumns = @JoinColumn(name = "spouse2_url"))
    List<CharacterPerson> spouse;
    @ManyToMany(mappedBy = "characters")
    List<Book> books;
    @ManyToMany(mappedBy = "povCharacters")
    List<Book> povBooks;
    String allegiances;
    String tvSeries;
    String playedBy;
}

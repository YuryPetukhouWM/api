package com.anapioficeandfire.api.model;

import java.util.List;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "houses")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class House extends ApiResource {
    String region;
    String coatOfArms;
    String words;
    String titles;
    String seats;
    @ManyToOne
    @JoinColumn(name = "current_lord_url")
    CharacterPerson currentLord;
    @ManyToOne
    @JoinColumn(name = "heir_url")
    CharacterPerson heir;
    @ManyToOne
    @JoinColumn(name = "overlord_url")
    CharacterPerson overlord;
    String founded;
    @ManyToOne
    @JoinColumn(name = "founder_url")
    CharacterPerson founder;
    String diedOut;
    String ancestralWeapons;
    @OneToMany
    @JoinTable(
            name = "house_cadet_branches",
            joinColumns = @JoinColumn(name = "house_url"),
            inverseJoinColumns = @JoinColumn(name = "cadet_branch_url"))
    List<House> cadetBranches;
    @OneToMany
    @JoinTable(
            name = "house_sworn_members",
            joinColumns = @JoinColumn(name = "house_url"),
            inverseJoinColumns = @JoinColumn(name = "character_url"))
    List<CharacterPerson> swornMembers;
}

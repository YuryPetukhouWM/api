package com.anapioficeandfire.api.mapper;

import com.anapioficeandfire.api.dto.CharacterDto;
import com.anapioficeandfire.api.dto.HouseDto;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.model.CharacterPerson;
import com.anapioficeandfire.api.model.House;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class HouseMapperImpl implements HouseMapper{
    @Override
    public HouseDto toDto(House house) {
        var builder = HouseDto.builder();
        builder.region(Objects.toString(house.getRegion(), ""));
        builder.titles(MappingUtils.parseArray(house.getTitles()));
        builder.coatOfArms(Objects.toString(house.getCoatOfArms(), ""));
        builder.words(Objects.toString(house.getWords(), ""));
        builder.seats(MappingUtils.parseArray(house.getSeats()));
        builder.currentLord(MappingUtils.getResourceUrl(house.getCurrentLord()));
        builder.heir(MappingUtils.getResourceUrl(house.getHeir()));
        builder.overlord(MappingUtils.getResourceUrl(house.getOverlord()));
        builder.founded(Objects.toString(house.getFounded(), ""));
        builder.founder(MappingUtils.getResourceUrl(house.getFounder()));
        builder.diedOut(Objects.toString(house.getDiedOut(), ""));
        builder.cadetBranches(Objects.isNull(house.getCadetBranches()) ? Collections.emptyList()
                : house.getCadetBranches().stream().map(House::getUrl).toList());
        builder.ancestralWeapons(MappingUtils.parseArray(house.getAncestralWeapons()));
        builder.swornMembers(Objects.isNull(house.getSwornMembers()) ? Collections.emptyList()
                : house.getSwornMembers().stream().map(CharacterPerson::getUrl).toList());
        var dto = builder.build();
        dto.setUrl(house.getUrl());
        dto.setName(Objects.toString(house.getName(), ""));
        return dto;
    }
}

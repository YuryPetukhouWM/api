package com.anapioficeandfire.api.mapper;

import com.anapioficeandfire.api.dto.HouseDto;
import com.anapioficeandfire.api.model.House;
import org.mapstruct.Mapper;

@Mapper
public interface HouseMapper {

    HouseDto toDto(House house);
}

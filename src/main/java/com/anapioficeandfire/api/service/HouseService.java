package com.anapioficeandfire.api.service;

import com.anapioficeandfire.api.dto.HouseDto;
import com.anapioficeandfire.api.model.House;
import java.util.List;
import java.util.Optional;

public interface HouseService {
    List<HouseDto> findAll(int page,
                           int size,
                           String name,
                           String region,
                           String words,
                           Boolean hasTitles,
                           Boolean hasSeats,
                           Boolean hasDiedOut,
                           Boolean hasAncestralWeapons);

    Optional<HouseDto> findByUrl(String requestURI);
}

package com.anapioficeandfire.api.controller;

import com.anapioficeandfire.api.dto.HouseDto;
import com.anapioficeandfire.api.model.CharacterPerson;
import com.anapioficeandfire.api.model.House;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HouseController {

    ResponseEntity<List<HouseDto>> findAll(int page,
                           int size,
                           String name,
                           String region,
                           String words,
                           Boolean hasWords,
                           Boolean hasTitles,
                           Boolean hasSeats,
                           Boolean hasDiedOut,
                           Boolean hasAncestralWeapons);

    ResponseEntity<HouseDto> findByUrl(HttpServletRequest request);
}

package com.anapioficeandfire.api.service;

import com.anapioficeandfire.api.dto.CharacterDto;
import com.anapioficeandfire.api.model.CharacterPerson;
import java.util.List;
import java.util.Optional;

public interface CharacterService {
    List<CharacterDto> findAll(int page, int size, String name, String gender, String culture, String born, String died, Boolean isAlive);

    Optional<CharacterDto> findByUrl(String requestURI);
}

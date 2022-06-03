package com.anapioficeandfire.api.controller;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.dto.CharacterDto;
import com.anapioficeandfire.api.dto.HouseDto;
import com.anapioficeandfire.api.model.CharacterPerson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CharacterController {

    ResponseEntity<List<CharacterDto>> findAll(int page,
                               int size,
                               String name,
                               String gender,
                               String culture,
                               String born,
                               String died,
                               Boolean isAlive);

    ResponseEntity<CharacterDto> findByUrl(HttpServletRequest request);
}

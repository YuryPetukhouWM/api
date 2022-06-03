package com.anapioficeandfire.api.controller;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.dto.CharacterDto;
import com.anapioficeandfire.api.model.CharacterPerson;
import com.anapioficeandfire.api.service.CharacterService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("characters")
@AllArgsConstructor
public class CharacterControllerImpl implements CharacterController {

    private CharacterService characterService;

    @GetMapping(path = "")
    @Override
    public ResponseEntity<List<CharacterDto>> findAll(@RequestParam(name = "page", defaultValue = "1") int page,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") int size,
                                                      @RequestParam(name = "name", required = false) String name,
                                                      @RequestParam(name = "gender", required = false) String gender,
                                                      @RequestParam(name = "culture", required = false) String culture,
                                                      @RequestParam(name = "born", required = false) String born,
                                                      @RequestParam(name = "died", required = false) String died,
                                                      @RequestParam(name = "isAlive", required = false) Boolean isAlive) {
        return ResponseEntity.ok(characterService.findAll(page, size, name, gender, culture, born, died, isAlive));
    }

    @GetMapping(path = "/{urlPart}")
    @Override
    public ResponseEntity<CharacterDto> findByUrl(HttpServletRequest request) {
        return characterService.findByUrl(request.getRequestURL().toString()).map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }
}

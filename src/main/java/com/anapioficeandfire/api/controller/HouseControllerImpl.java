package com.anapioficeandfire.api.controller;

import com.anapioficeandfire.api.dto.BookDto;
import com.anapioficeandfire.api.dto.HouseDto;
import com.anapioficeandfire.api.model.House;
import com.anapioficeandfire.api.service.HouseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("houses")
@AllArgsConstructor
public class HouseControllerImpl implements HouseController {

    private HouseService houseService;

    @GetMapping(path = "")
    @Override
    public ResponseEntity<List<HouseDto>> findAll(@RequestParam(name = "page", defaultValue = "1") int page,
                                                  @RequestParam(name = "pageSize", defaultValue = "10") int size,
                                                  @RequestParam(name = "name", required = false) String name,
                                                  @RequestParam(name = "region", required = false) String region,
                                                  @RequestParam(name = "words", required = false) String words,
                                                  @RequestParam(name = "hasWords", required = false) Boolean hasWords,
                                                  @RequestParam(name = "hasTitles", required = false) Boolean hasTitles,
                                                  @RequestParam(name = "hasSeats", required = false) Boolean hasSeats,
                                                  @RequestParam(name = "hasDiedOut", required = false) Boolean hasDiedOut,
                                                  @RequestParam(name = "hasAncestralWeapons", required = false) Boolean hasAncestralWeapons) {
        return ResponseEntity.ok(
                houseService.findAll(page, size, name, region, words, hasTitles, hasSeats, hasDiedOut, hasAncestralWeapons));
    }

    @GetMapping(path = "/{urlPart}")
    @Override
    public ResponseEntity<HouseDto> findByUrl(HttpServletRequest request) {
        return houseService.findByUrl(request.getRequestURL().toString()).map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}

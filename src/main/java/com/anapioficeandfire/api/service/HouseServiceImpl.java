package com.anapioficeandfire.api.service;

import com.anapioficeandfire.api.dto.HouseDto;
import com.anapioficeandfire.api.mapper.HouseMapper;
import com.anapioficeandfire.api.model.House;
import com.anapioficeandfire.api.repository.HouseRepository;
import com.anapioficeandfire.api.repository.SearchCriteria;
import com.anapioficeandfire.api.repository.SearchSpecification;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {

    private HouseRepository repository;
    private HouseMapper mapper;

    @Override
    public List<HouseDto> findAll(int page,
                                  int size,
                                  String name,
                                  String region,
                                  String words,
                                  Boolean hasTitles,
                                  Boolean hasSeats,
                                  Boolean hasDiedOut,
                                  Boolean hasAncestralWeapons) {
        var searchSpecfication = buildSearchSpecification(name, region, words, hasTitles, hasSeats, hasDiedOut, hasAncestralWeapons);
        return repository.findAll(searchSpecfication, PageRequest.of(page-1, size)).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<HouseDto> findByUrl(String requestURI) {
        return repository.findById(requestURI).map(mapper::toDto);
    }


    private Specification<House> buildSearchSpecification(String name,
                                                          String region,
                                                          String words,
                                                          Boolean hasTitles,
                                                          Boolean hasSeats,
                                                          Boolean hasDiedOut,
                                                          Boolean hasAncestralWeapons) {
        var specifications = new ArrayList<Specification<House>>();
        if (Objects.nonNull(name)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("name", ":", name)));
        }
        if (Objects.nonNull(region)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("region", ":", region)));
        }
        if (Objects.nonNull(words)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("words", ":", words)));
        }
        addHasSpecification(specifications, hasTitles, "titles");
        addHasSpecification(specifications, hasSeats, "seats");
        addHasSpecification(specifications, hasDiedOut, "died_out");
        addHasSpecification(specifications, hasAncestralWeapons, "ancestral_weapons");
        return specifications.stream().reduce((x,y) -> x.and(y)).orElse(null);
    }

    private void addHasSpecification(List<Specification<House>> specifications, Boolean parameterValue, String keyName) {
        if (Objects.nonNull(parameterValue)) {
            if (parameterValue) {
                specifications.add(new SearchSpecification<>(new SearchCriteria(keyName, "isNotNull", null)));
            } else {
                specifications.add(new SearchSpecification<>(new SearchCriteria(keyName, "isNull", null)));
            }
        }
    }
}

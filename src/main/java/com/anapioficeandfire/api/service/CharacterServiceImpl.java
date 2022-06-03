package com.anapioficeandfire.api.service;

import com.anapioficeandfire.api.dto.CharacterDto;
import com.anapioficeandfire.api.mapper.CharacterMapper;
import com.anapioficeandfire.api.model.Book;
import com.anapioficeandfire.api.model.CharacterPerson;
import com.anapioficeandfire.api.repository.CharacterPersonRepository;
import com.anapioficeandfire.api.repository.SearchCriteria;
import com.anapioficeandfire.api.repository.SearchSpecification;
import java.time.LocalDate;
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
public class CharacterServiceImpl implements CharacterService {

    private CharacterPersonRepository repository;
    private CharacterMapper mapper;

    @Override
    public List<CharacterDto> findAll(int page,
                                      int size,
                                      String name,
                                      String gender,
                                      String culture,
                                      String born,
                                      String died,
                                      Boolean isAlive) {
        var searchSpecfication = buildSearchSpecification(name, gender, culture, born, died, isAlive);
        return repository.findAll(searchSpecfication, PageRequest.of(page - 1, size)).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<CharacterDto> findByUrl(String requestURI) {
        return repository.findById(requestURI).map(mapper::toDto);
    }

    private Specification<CharacterPerson> buildSearchSpecification(String name,
                                                                    String gender,
                                                                    String culture,
                                                                    String born,
                                                                    String died,
                                                                    Boolean isAlive) {
        var specifications = new ArrayList<Specification<CharacterPerson>>();
        if (Objects.nonNull(name)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("name", ":", name)));
        }
        if (Objects.nonNull(gender)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("gender", ":", gender)));
        }
        if (Objects.nonNull(culture)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("culture", ":", culture)));
        }
        if (Objects.nonNull(born)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("born", ":", born)));
        }
        if (Objects.nonNull(died)) {
            specifications.add(new SearchSpecification<>(new SearchCriteria("died", ":", died)));
        }
        if (Objects.nonNull(isAlive)) {
            if (isAlive) {
                specifications.add(new SearchSpecification<>(new SearchCriteria("died", "isNull", null)));
            } else {
                specifications.add(new SearchSpecification<>(new SearchCriteria("died", "isNotNull", null)));
            }
        }
        return specifications.stream().reduce((x,y) -> x.and(y)).orElse(null);
    }
}

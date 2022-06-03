package com.anapioficeandfire.api.repository;

import com.anapioficeandfire.api.model.CharacterPerson;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CharacterPersonRepository
        extends PagingAndSortingRepository<CharacterPerson, String>, JpaSpecificationExecutor<CharacterPerson> {

    Page<CharacterPerson> findAll(Specification spec, Pageable p);
}

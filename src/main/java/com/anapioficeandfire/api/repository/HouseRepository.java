package com.anapioficeandfire.api.repository;

import com.anapioficeandfire.api.model.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository
        extends PagingAndSortingRepository<House, String>, JpaSpecificationExecutor<House> {

    Page<House> findAll(Specification spec, Pageable p);

}

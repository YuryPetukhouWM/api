package com.anapioficeandfire.api.repository;

import com.anapioficeandfire.api.model.Book;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository
        extends PagingAndSortingRepository<Book, String>, JpaSpecificationExecutor<Book> {

    Page<Book> findAll(Specification spec, Pageable p);

    Optional<Book> findById(String id);

}

package com.prac.spring.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prac.spring.Model.Taco;

public interface TacoRepository
        extends PagingAndSortingRepository<Taco, Long> {

    Taco save(Taco taco);

    Optional<Taco> findById(Long id);
}

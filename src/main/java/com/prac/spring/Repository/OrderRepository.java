package com.prac.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.prac.spring.Model.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    
}

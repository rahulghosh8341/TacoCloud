package com.prac.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.prac.spring.Model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient,String>{
    
}

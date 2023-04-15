package com.prac.spring.Controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.prac.spring.Model.Ingredient;
import com.prac.spring.Repository.IngredientRepository;


@Component
public class IngredientByIdConverterJdbc implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;

    public IngredientByIdConverterJdbc(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }

}
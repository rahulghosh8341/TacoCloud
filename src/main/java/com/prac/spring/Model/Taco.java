package com.prac.spring.Model;

//Simple fetching data from list
// import java.util.List;

// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
// import lombok.Data;

// @Data
// public class Taco {
//     @NotNull
//     @Size(min = 5, message = "Name must be at least 5 characters long")
//     private String name;
//     @NotNull
//     @Size(min = 1, message = "You must choose at least 1 ingredient")
//     private List<Ingredient> ingredients;
// }
//Adding persistence jdbc

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
// Exclude createdAt from equals() method so that tests won't fail trying to
// compare java.util.Date with java.sql.Timestamp (even though they're
// essentially
// equal). Need to figure out a better way than this, but excluding this
// property
// for now.
@EqualsAndHashCode(exclude = "createdAt")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

}
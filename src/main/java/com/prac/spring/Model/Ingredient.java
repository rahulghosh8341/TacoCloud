package com.prac.spring.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
// public class Ingredient {
//     private final String id;
//     private final String name;
//     private final Type type;

//     public enum Type {
//         WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
//     }
// }

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private String id;

    private String name;
    private Type type;

    // @Override
    // public boolean isNew() {
    //     return true;
    // }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}

package com.prac.spring.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@Table
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient implements Persistable<String> {

    @Id
    private String id;

    private String name;
    private Type type;

    @Override
    public boolean isNew() {
        return true;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}

package org.example.lab8.models;

import java.util.Objects;
import lombok.Data;

@Data
public class Recipe {
    protected int id;
    protected String name;
    protected int numberOfDishes;
    protected int caloric;

    Recipe(int id, String name, int numberOfDishes, int caloric) {
        this.id = id;
        this.name = name;
        this.numberOfDishes = numberOfDishes;
        this.caloric = caloric;
    }
    protected Recipe(){

    }
}
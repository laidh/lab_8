package models;

import lombok.Data;
@Data
public class Recipe {
    protected String name;
    protected int numberOfDishes;
    protected int caloric;

    Recipe(String name, int numberOfDishes, int caloric) {
        this.name = name;
        this.numberOfDishes = numberOfDishes;
        this.caloric = caloric;
    }
    protected Recipe(){

    }
}

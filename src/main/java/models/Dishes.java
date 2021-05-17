package models;

import enums.Dish;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Dishes extends Recipe {
    private int mass;
    private Dish dish;

    public Dishes(String name, int numberOfDishes, int caloric, int mass, Dish dish) {
        super(name, numberOfDishes, caloric);
        this.mass = mass;
        this.dish = dish;
    }
}

package models;

import enums.Drink;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Drinks extends Recipe {
    private int volume;
    private Drink drink;

    public Drinks(String name, int numberOfDishes, int caloric, int volume, Drink drink) {
        super(name, numberOfDishes, caloric);
        this.volume = volume;
        this.drink = drink;

    }
}

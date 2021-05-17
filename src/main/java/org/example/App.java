package org.example;

import enums.Dish;
import enums.Drink;
import enums.SortOrder;
import manager.Manager;
import models.Dishes;
import models.Drinks;
import models.Recipe;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Recipe> objects = List.of(
                new Drinks("name", 2, 100, 500, Drink.MILK),
                new Dishes("name", 5, 300, 120, Dish.COTTAGE_CHEESE),
                new Drinks("nam", 4, 600, 500, Drink.COCOA)
        );
        Manager manager = new Manager(objects);
        System.out.println("Checking for enough amount of players");
        Manager.print(manager.searchByNumberOfDishes(5));
        System.out.println("--------------------------------------------");

        System.out.println("Sorting by Caloric\n");
        Manager.print(manager.sortByCaloric(SortOrder.ASC));
        System.out.println("--------------------------------------------");

        System.out.println("Sorting by Number of dishes\n");
        Manager.print(manager.sortByNumberOfDishes(SortOrder.ASC));
        System.out.println("--------------------------------------------");
    }
}

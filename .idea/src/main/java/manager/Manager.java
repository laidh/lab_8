package manager;

import lombok.AllArgsConstructor;
import models.Recipe;
import enums.SortOrder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Manager {
    private final List<Recipe> objects;

    public List<Recipe> sortByNumberOfDishes(SortOrder sortOrder) {
        List<Recipe> objectSorted = new ArrayList<>(objects);
        if (SortOrder.ASC == sortOrder) {
            objectSorted.sort(Comparator.comparing(Recipe::getNumberOfDishes));
        } else {
            objectSorted.sort(Comparator.comparing(Recipe::getNumberOfDishes).reversed());
        }
        return objectSorted;
    }
    public List<Recipe> sortByCaloric(SortOrder sortOrder) {
        List<Recipe> objectSorted = new ArrayList<>(objects);
        if (SortOrder.ASC == sortOrder) {
            objectSorted.sort(Comparator.comparing(Recipe::getCaloric));
        } else {
            objectSorted.sort(Comparator.comparing(Recipe::getCaloric).reversed());
        }
        return objectSorted;
    }
    public List<Recipe> searchByNumberOfDishes(int number) {
        return objects.stream().filter(object -> object.getNumberOfDishes() == number).collect(Collectors.toList());
    }
    public static void print(List<Recipe> objects) {
        objects.forEach(System.out::println);
    }
}

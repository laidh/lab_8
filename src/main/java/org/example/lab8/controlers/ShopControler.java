package org.example.lab8.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.lab8.models.Recipe;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/recipe")
@RestController
public class ShopControler {
    private final Map<Integer, Recipe> recipes = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public Collection<Recipe> getRecipes() {
        return new ArrayList<Recipe>(recipes.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") Integer id) {

        if (recipes.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes.get(id));

    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Recipe createRecipes(final @RequestBody Recipe recipe) {
        recipe.setId(idCounter.incrementAndGet());
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Recipe> deleteRecipes(@PathVariable("id") int id) {
        HttpStatus status;
        if (recipes.get(id) == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.OK;
            recipes.remove(id);
        }
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Recipe> updateRecipes(final @PathVariable("id") int id, final @RequestBody Recipe recipe) {
        HttpStatus status;
        if (recipes.get(id) == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.OK;
            recipe.setId(id);
            recipes.put(id, recipe);
        }
        return ResponseEntity.status(status).build();
    }
}
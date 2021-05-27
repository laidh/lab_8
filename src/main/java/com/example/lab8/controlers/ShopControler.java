package com.example.lab8.controlers;

import com.example.lab8.repos.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lab8.models.Recipe;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/recipe")
@RestController
public class ShopControler {
    @Autowired
    private RecipeRepository recipeRepository;
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public Iterable<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") Integer id) {

        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Recipe createRecipes(final @RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteRecipes(@PathVariable("id") int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            recipeRepository.delete(recipe.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Recipe> updateRecipes(final @PathVariable("id") int id, final @RequestBody Recipe recipe) {
        Optional<Recipe> oldRecipe = recipeRepository.findById(id);
        if (oldRecipe.isPresent()) {
            recipe.setId(id);
            recipeRepository.save(recipe);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
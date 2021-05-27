package com.example.lab8.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
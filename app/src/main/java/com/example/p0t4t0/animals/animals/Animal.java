package com.example.p0t4t0.animals.animals;

public class Animal {
    private String spies;
    private String name;
    private int weight;

    public Animal(String spies, String name, int weight) {
        this.spies = spies;
        this.name = name;
        this.weight = weight;
    }

    public String getSpies() {
        return spies;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

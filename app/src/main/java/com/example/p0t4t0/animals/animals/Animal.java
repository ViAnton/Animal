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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        return weight == animal.weight
                && spies.equals(animal.spies)
                && name.equals(animal.name);

    }

    @Override
    public int hashCode() {
        int result = spies.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + weight;
        return result;
    }
}

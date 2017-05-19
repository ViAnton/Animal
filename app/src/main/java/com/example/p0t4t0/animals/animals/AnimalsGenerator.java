package com.example.p0t4t0.animals.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalsGenerator {
    private static List<Animal> animals = new ArrayList<>();

    static {
        generateAnimals();
    }

    public static Animal getRandomAnimal() {
        Random random = new Random();
        return animals.get(random.nextInt(animals.size()));
    }

    private static void generateAnimals() {
        animals.add(new Animal("Кот", "Обормот", 45));
        animals.add(new Animal("Собака", "Пугака", 68));
        animals.add(new Animal("Мышь", "Глупыш", 12));
        animals.add(new Animal("Муравей", "Аркадий", 5));
        animals.add(new Animal("Бык", "Федя", 100));
    }
}

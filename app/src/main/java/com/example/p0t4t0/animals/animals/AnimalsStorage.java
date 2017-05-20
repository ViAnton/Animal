package com.example.p0t4t0.animals.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalsStorage {
    private final static List<Animal> mAnimals = new ArrayList<>();
    private final static List<OnAnimalAddedListener> mOnAnimalAddedListeners = new ArrayList<>();

    static {
        generateAnimals();
    }

    public static List<Animal> getAnimals() {
        return new ArrayList<>(mAnimals);
    }

    public static boolean addListener(OnAnimalAddedListener listener) {
        return mOnAnimalAddedListeners.add(listener);
    }

    public static boolean removeListener(OnAnimalAddedListener listener) {
        return mOnAnimalAddedListeners.remove(listener);
    }

    private static void generateAnimals() {
        mAnimals.add(new Animal("Кот", "Обормот", 45));
        mAnimals.add(new Animal("Собака", "Пугака", 68));
        mAnimals.add(new Animal("Мышь", "Глупыш", 12));
        mAnimals.add(new Animal("Муравей", "Аркадий", 5));
        mAnimals.add(new Animal("Бык", "Федя", 100));
    }

    public static void addAnimal(Animal animal) {
        mAnimals.add(animal);

        for (OnAnimalAddedListener listener : mOnAnimalAddedListeners)
            listener.onAnimalAdded();
    }

    public interface OnAnimalAddedListener {
        void onAnimalAdded();
    }
}

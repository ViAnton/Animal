package com.example.p0t4t0.animals.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalsStorage {
    private final List<Animal> mAnimals;
    private final List<OnAnimalAddedListener> mOnAnimalAddedListeners;

    public AnimalsStorage() {
        mAnimals = new ArrayList<>();
        mOnAnimalAddedListeners = new ArrayList<>();
        generateAnimals();
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(mAnimals);
    }

    public boolean addListener(OnAnimalAddedListener listener) {
        return mOnAnimalAddedListeners.add(listener);
    }

    public boolean removeListener(OnAnimalAddedListener listener) {
        return mOnAnimalAddedListeners.remove(listener);
    }

    private void generateAnimals() {
        mAnimals.add(new Animal("Кот", "Обормот", 45));
        mAnimals.add(new Animal("Собака", "Пугака", 68));
        mAnimals.add(new Animal("Мышь", "Глупыш", 12));
        mAnimals.add(new Animal("Муравей", "Аркадий", 5));
        mAnimals.add(new Animal("Бык", "Федя", 100));
    }

    public void addAnimal(Animal animal) {
        mAnimals.add(animal);

        for (OnAnimalAddedListener listener : mOnAnimalAddedListeners)
            listener.onAnimalAdded();
    }

    public interface OnAnimalAddedListener {
        void onAnimalAdded();
    }
}

package com.example.p0t4t0.animals;

import android.app.Application;

import com.example.p0t4t0.animals.animals.AnimalsStorage;

public class AnimalApplicationProvider extends Application {
    private AnimalsStorage mAnimalsStorage;

    public AnimalsStorage getAnimalsStorage() {
        if (mAnimalsStorage == null)
            mAnimalsStorage = new AnimalsStorage();

        return mAnimalsStorage;
    }
}

package com.example.p0t4t0.animals.animals;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class AnimalLoader extends AsyncTaskLoader<Animal> {

    public AnimalLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Animal loadInBackground() {
        return AnimalsGenerator.getRandomAnimal();
    }
}

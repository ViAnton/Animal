package com.example.p0t4t0.animals.animals;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class AnimalLoader extends AsyncTaskLoader<List<Animal>>
        implements AnimalsStorage.OnAnimalAddedListener {

    private List<Animal> mCachedAnimalsList;

    public AnimalLoader(Context context) {
        super(context);
        AnimalsStorage.addListener(this);
    }

    @Override
    protected void onStartLoading() {
        if (mCachedAnimalsList == null || takeContentChanged())
            forceLoad();
    }

    @Override
    public List<Animal> loadInBackground() {
        return AnimalsStorage.getAnimals();
    }

    @Override
    public void deliverResult(List<Animal> data) {
        super.deliverResult(data);
        mCachedAnimalsList = data;
    }

    @Override
    protected void onReset() {
        AnimalsStorage.removeListener(this);
    }

    @Override
    public void onAnimalAdded() {
        onContentChanged();
    }
}

package com.example.p0t4t0.animals.animals;

import android.app.Application;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.p0t4t0.animals.AnimalApplicationProvider;

import java.util.List;

public class AnimalLoader extends AsyncTaskLoader<List<Animal>>
        implements AnimalsStorage.OnAnimalAddedListener {

    private List<Animal> mCachedAnimalsList;
    private AnimalsStorage mAnimalsStorage;

    public AnimalLoader(Context context, Application mApplication) {
        super(context);
        mAnimalsStorage = ((AnimalApplicationProvider) mApplication).getAnimalsStorage();
        mAnimalsStorage.addListener(this);
    }

    @Override
    protected void onStartLoading() {
        if (mCachedAnimalsList == null || takeContentChanged())
            forceLoad();
    }

    @Override
    public List<Animal> loadInBackground() {
        return mAnimalsStorage.getAnimals();
    }

    @Override
    public void deliverResult(List<Animal> data) {
        super.deliverResult(data);
        mCachedAnimalsList = data;
    }

    @Override
    protected void onReset() {
        mAnimalsStorage.removeListener(this);
    }

    @Override
    public void onAnimalAdded() {
        onContentChanged();
    }
}

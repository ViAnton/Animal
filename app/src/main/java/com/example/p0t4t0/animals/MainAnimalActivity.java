package com.example.p0t4t0.animals;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.p0t4t0.animals.animals.Animal;
import com.example.p0t4t0.animals.animals.AnimalLoader;

public class MainAnimalActivity extends AppCompatActivity {

    private final static int LOADER_ID = 969;

    private TextView mAnimalSpiesView;
    private TextView mAnimalNameView;
    private TextView mAnimalWeightView;

    private Button mUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animal);

        mAnimalSpiesView = (TextView) findViewById(R.id.animal_spies);
        mAnimalNameView = (TextView) findViewById(R.id.animal_name);
        mAnimalWeightView = (TextView) findViewById(R.id.animal_weight);

        mUpdateButton = (Button) findViewById(R.id.update_button);
        mUpdateButton.setOnClickListener(new UpdateButtonListener());

        getSupportLoaderManager().initLoader(LOADER_ID, null,
                new AnimalLoaderCallBack());
    }

    private class AnimalLoaderCallBack implements LoaderManager.LoaderCallbacks<Animal> {

        @Override
        public Loader<Animal> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainAnimalActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<Animal> loader, Animal data) {
            mAnimalSpiesView.setText(data.getSpies());
            mAnimalNameView.setText(data.getName());
            mAnimalWeightView.setText(Integer.toString(data.getWeight()));
        }

        @Override
        public void onLoaderReset(Loader<Animal> loader) {

        }
    }

    private class UpdateButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            getSupportLoaderManager().getLoader(LOADER_ID).forceLoad();
        }
    }
}

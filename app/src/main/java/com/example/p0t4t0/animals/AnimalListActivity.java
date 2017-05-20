package com.example.p0t4t0.animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.p0t4t0.animals.animals.Animal;
import com.example.p0t4t0.animals.animals.AnimalListAdapter;
import com.example.p0t4t0.animals.animals.AnimalLoader;

import java.util.List;

public class MainAnimalActivity extends AppCompatActivity {

    private final static int LOADER_ID = 969;
    private ListView mListView;
    private AnimalListAdapter mAnimalListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animal);

        mListView = (ListView) findViewById(R.id.animal_list_view);
        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalCallBack()).forceLoad();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_option:
                Intent intent = new Intent(this, AddAnimalActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class AnimalCallBack implements LoaderManager.LoaderCallbacks<List<Animal>> {

        @Override
        public Loader<List<Animal>> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainAnimalActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<List<Animal>> loader, List<Animal> data) {
            if (mAnimalListAdapter == null) {
                mAnimalListAdapter = new AnimalListAdapter();
                mAnimalListAdapter.setAnimals(data);
                mListView.setAdapter(mAnimalListAdapter);
            }

            mAnimalListAdapter.setAnimals(data);
        }

        @Override
        public void onLoaderReset(Loader<List<Animal>> loader) {

        }
    }
}

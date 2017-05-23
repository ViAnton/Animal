package com.example.p0t4t0.animals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p0t4t0.animals.animals.Animal;

public class AddAnimalActivity extends AppCompatActivity {

    private EditText mAnimalSpiesEditView;
    private EditText mAnimalNameEditView;
    private EditText mAnimalWeightEditView;

    private Button mCreateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        mAnimalSpiesEditView = (EditText) findViewById(R.id.animal_spies_edit_text);
        mAnimalNameEditView = (EditText) findViewById(R.id.animal_name_edit_text);
        mAnimalWeightEditView = (EditText) findViewById(R.id.animal_weight_edit_text);

        mCreateButton = (Button) findViewById(R.id.create_button);
        mCreateButton.setOnClickListener(new CreateButtonListener());
    }

    private class CreateButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String spies = mAnimalSpiesEditView.getText().toString();
            String name = mAnimalNameEditView.getText().toString();
            String weight = mAnimalWeightEditView.getText().toString();

            if (checkArgs(spies, name, weight)) {
                Animal animal = new Animal(spies, name, Integer.parseInt(weight));
                ((AnimalApplicationProvider) getApplication())
                        .getAnimalsStorage()
                        .addAnimal(animal);
                finish();
            } else
                Toast.makeText(v.getContext(),
                        "Заполните все поля",
                        Toast.LENGTH_SHORT)
                        .show();
        }

        private boolean checkArgs(String... args) {
            for (String st : args)
                if (st.isEmpty())
                    return false;

            return true;
        }
    }
}
